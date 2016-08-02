package com.goit.gojavaonline.corefinalproject.read;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Danil-MAC on 7/30/16.
 */
public class FileInput implements IInput {

    private File file;

    public FileInput(String fileName) {
        file = new File(fileName);
    }

    @Override
    public List<String> read() throws IOException {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(file.getName()), StandardCharsets.UTF_8);
            return lines;
        } catch (FileNotFoundException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return lines;
    }

}
