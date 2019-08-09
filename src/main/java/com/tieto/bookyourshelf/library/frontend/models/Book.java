package com.tieto.bookyourshelf.library.frontend.models;

public class Book {
    private String title;
    private String barCode;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setBarCode(String barcode) {
        this.barCode = barcode;
    }

    public String getBarCode() {
        return this.barCode;
    }
}
