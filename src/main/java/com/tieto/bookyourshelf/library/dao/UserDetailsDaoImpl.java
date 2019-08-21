package com.tieto.bookyourshelf.library.dao;




import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import com.tieto.bookyourshelf.library.dao.entityes.UserEnt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDetailsDaoImpl implements UserDetailsDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public UserEnt findByEmail(String email) {
        List<UserEnt> userList = new ArrayList<UserEnt>();
        Query query = openSession().createQuery("from UserEnt u where u.email = :email");
        query.setParameter("email", email);
        userList = query.list();
        if (userList.size() > 0)
            return userList.get(0);
        else
            return null;
    }





    @Override
    public List<UserEnt> findAll() {
        return null;
    }

    @Override
    public List<UserEnt> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<UserEnt> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<UserEnt> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(UserEnt userEnt) {

    }

    @Override
    public void deleteAll(Iterable<? extends UserEnt> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends UserEnt> S save(S s) {
        return null;
    }

    @Override
    public <S extends UserEnt> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<UserEnt> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends UserEnt> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<UserEnt> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public UserEnt getOne(String s) {
        return null;
    }

    @Override
    public <S extends UserEnt> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends UserEnt> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends UserEnt> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends UserEnt> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends UserEnt> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends UserEnt> boolean exists(Example<S> example) {
        return false;
    }
}

