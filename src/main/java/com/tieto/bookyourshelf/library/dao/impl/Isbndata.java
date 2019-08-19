package com.tieto.bookyourshelf.library.dao.impl;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Isbndata {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
