package com.tieto.bookyourshelf.library.service;

import com.tieto.bookyourshelf.library.UserAlreadyExistException;
import com.tieto.bookyourshelf.library.dao.UserDao;
import com.tieto.bookyourshelf.library.dao.entityes.UserEnt;
import com.tieto.bookyourshelf.library.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.client.RestTemplate;

import java.io.FileOutputStream;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static String UPLOADED_FOLDER = "C:/pics/unknown_people/";
    private final String faceRecServer="http://192.168.1.193:8000/";

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> getAllUsers() {
        List<UserEnt> userEntities=userDao.findAll();
        List<UserDto> users = userEntities.stream().map(e -> entToDto(e, null)).collect(Collectors.toList());
        return users;
    }

    @Override
    public UserDto getUserById(Long id) {
        Optional<UserEnt> user=userDao.findById(id);
        return entToDto(user.get(), null);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public UserEnt saveUser(UserDto user) throws UserAlreadyExistException{
        if (emailExist(user.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email address: " + user.getEmail());
        } else {
            UserEnt userEntity = new UserEnt();
            userEntity = dtoToEnt(user, userEntity);
            userDao.save(userEntity);
            return userEntity;
        }
    }

    @Override
    public UserEnt editUser(UserDto user) {

        UserEnt userEntity = userDao.findById(user.getId()).get();
        userEntity = dtoToEnt(user, userEntity);
        userDao.save(userEntity);
        return userEntity;
    }

    private boolean emailExist(String email) {
        return userDao.findByEmail(email) != null;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        UserDto dto = new UserDto();
        UserEnt ent = userDao.findUserEntByEmail(email);
        dto = entToDto(ent, dto);
        return dto;
    }

    @Override
    public String faceRecognition(String imageBase64){


        String encodedImg = imageBase64.split(",")[1];
        byte[] imageByteArray= Base64.getDecoder().decode(encodedImg);

        FileOutputStream imageOutFile = null;
        try {
            imageOutFile = new FileOutputStream(
                    UPLOADED_FOLDER + "unknown.jpg");
            imageOutFile.write(imageByteArray);
            imageOutFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = faceRecServer+"faceRecognition/?imageUrl=";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl + "unknown.jpg", String.class);
        return response.getBody();
    }



    private UserEnt dtoToEnt(UserDto dto, UserEnt ent) {
        if (dto == null) {
            return null;
        }
        if (ent == null) {
            throw new IllegalArgumentException("Argument ent can not be null");
        }
        //ent.setId(dto.getId());
        ent.setFirstName(dto.getFirstName());
        ent.setLastName(dto.getLastName());
        ent.setEmail(dto.getEmail());
       // ent.setPassword(dto.getPassword());
        ent.setPassword(passwordEncoder.encode(dto.getPassword()));
        ent.setPicture(dto.getPicture());
        ent.setRole(dto.getRole());
        return ent;

    }

    private UserDto entToDto(UserEnt ent, UserDto dto) {
        if (ent == null) {
            return null;
        }
        if (dto == null) {
            dto = new UserDto();
        }
        dto.setId(ent.getId());
        dto.setFirstName(ent.getFirstName());
        dto.setLastName(ent.getLastName());
        dto.setPicture(ent.getPicture());
        dto.setEmail(ent.getEmail());
        dto.setPassword(ent.getPassword());
        dto.setRole(ent.getRole());

        return dto;
    }


}
