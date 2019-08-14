package com.tieto.bookyourshelf.library.dao.impl;

import com.tieto.bookyourshelf.library.dao.PersonDao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import org.springframework.stereotype.Repository;

//@Repository
public class FileDriver implements PersonDao {
    private static String TEXT_FILE_PATH = "/dev/test/test.txt";

    public String loadPerson() throws IOException {
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

    public void savePerson(String person, boolean append) throws IOException {
        FileWriter fileWriter = new FileWriter(TEXT_FILE_PATH, append);
        fileWriter.append(person);
        fileWriter.close();
    }
}
