package com.goit.gojavaonline.corefinalproject.write;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Danil-MAC on 7/30/16.
 */
public class FileOutput implements IOutput {

    private File file;

    public FileOutput(String fileName) {
        file = new File(fileName);
    }

    public void write(List<String> list) throws IOException {
        FileWriter out = new FileWriter(file);
        try {
            for (String word: list) {
                out.write(word);
            }
        } finally {
            out.close();
        }
    }
}
