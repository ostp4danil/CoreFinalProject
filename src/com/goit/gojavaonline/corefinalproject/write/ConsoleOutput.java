package com.goit.gojavaonline.corefinalproject.write;

import java.io.File;
import java.util.List;

public class ConsoleOutput implements IOutput {

    @Override
    public void write(List<String> list) {
        for (String word : list) {
            System.out.println(word);
        }
    }
}
