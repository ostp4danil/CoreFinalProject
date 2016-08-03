package main.com.goit.gojavaonline.corefinalproject.dictionary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    private String word;
    private List<String> dictionary = new ArrayList<>();


    public Dictionary(List<String> dictionary){
        this.dictionary.addAll(dictionary);
    }


    private boolean isWordAcceptableByLength(String word){
        return this.word.length() == word.length();
    }

    public List<String> getWordsWithSameLength(String word) {
        this.word=word;
        List<String> preparedWords = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();
        for (String line: dictionary) {
            currentWord.append(line);
            if (isWordAcceptableByLength(currentWord.toString())){
                preparedWords.add(currentWord.toString());
            }
            currentWord.delete(0,currentWord.length());
        }
        return preparedWords;
    }


}
