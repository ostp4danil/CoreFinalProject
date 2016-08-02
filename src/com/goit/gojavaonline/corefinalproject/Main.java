package com.goit.gojavaonline.corefinalproject;

import com.goit.gojavaonline.corefinalproject.dictionary.Dictionary;
import com.goit.gojavaonline.corefinalproject.read.FileInput;
import com.goit.gojavaonline.corefinalproject.write.ConsoleOutput;
import com.goit.gojavaonline.corefinalproject.write.IOutput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        List<String> fileData = new ArrayList<>();
        for(int i=1; i<=3; i++){
            String currentName="English"+i+".txt";
            FileInput fileInput = new FileInput(currentName);
            fileData.addAll(fileInput.read());
        }
        Dictionary dictionary = new Dictionary(fileData);
        List<String> words = dictionary.getWordsByLength("apple");
        IOutput output = new ConsoleOutput();
    }

}

