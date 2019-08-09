package com.tieto.bookyourshelf.library.dao.impl;

import com.tieto.bookyourshelf.library.dao.BookDao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import org.springframework.stereotype.Repository;

@Repository
public class FileDriver2 implements BookDao{
    private static String TEXT_FILE_PATH = "/dev/test/test2.txt";

    public String loadBook() throws IOException {
        FileReader fileReader;
        try {
            fileReader = new FileReader(TEXT_FILE_PATH);
        } catch (FileNotFoundException e) {
            return null;
        }
        CharBuffer charBuffer = CharBuffer.allocate(50);
        fileReader.read(charBuffer);
        //flip char buffer
        charBuffer.flip();
        fileReader.close();
        return charBuffer.toString();
    }

    public void saveBook(String book, boolean append) throws IOException {
        FileWriter fileWriter = new FileWriter(TEXT_FILE_PATH, append);
        fileWriter.append(book);
        fileWriter.close();
    }
}

