package com.tieto.bookyourshelf.library.service;

import com.tieto.bookyourshelf.library.dao.BorrowDao;
import com.tieto.bookyourshelf.library.service.dto.BorrowDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowDao borrowDao;



}
