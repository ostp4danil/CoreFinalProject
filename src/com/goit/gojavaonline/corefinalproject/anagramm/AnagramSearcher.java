package com.goit.gojavaonline.corefinalproject.anagramm;

import com.goit.gojavaonline.corefinalproject.dictionary.Dictionary;
import com.sun.media.sound.InvalidDataException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.Character.*;

public class AnagramSearcher implements IAnagramSearcher {

    final private static int DOT_CODE = 46;
    final private static int EXCLAMATION_MARK_CODE = 33;
    final private static int QUESTION_MARK_CODE = 63;
    final private static int COLON_CODE = 58;
    final private static int SEMICOLON_CODE = 59;
    final private static int COMMA_CODE = 44;
    final private static int SPACE_CODE = 32;

    private Dictionary dictionary;

    public AnagramSearcher(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public AnagramSearcher() {
    }

    @Override
    public boolean isAnagram(String firstWord, String secondWord) {
        Map<Character, Integer> characterMapOfFirstWord;
        Map<Character, Integer> characterMapOfSecondWord;
        char[] charsOfFirstWord = firstWord.toCharArray();
        char[] charsOfSecondWord = secondWord.toCharArray();

        try {
            characterMapOfFirstWord = recountCharsInWord(charsOfFirstWord);
            characterMapOfSecondWord = recountCharsInWord(charsOfSecondWord);

            return characterMapOfFirstWord.equals(characterMapOfSecondWord);
        } catch (InvalidDataException e) {
            return false;
        }


    }

    private Map<Character, Integer> recountCharsInWord(char[] chars) throws InvalidDataException {

        Map<Character, Integer> characterMap = new TreeMap<>();

        for (char character : chars) {
            Integer charCode = (int) character;
            if (isAlphabetic(charCode)) {
                if (characterMap.containsKey(character)) {
                    int count = characterMap.get(character);
                    characterMap.put(character, count + 1);
                } else {
                    characterMap.put(character, 1);
                }
            } else if (!charCode.equals(SEMICOLON_CODE) && !charCode.equals(COLON_CODE) && !charCode.equals(QUESTION_MARK_CODE)
                    && !charCode.equals(EXCLAMATION_MARK_CODE) && !charCode.equals(COMMA_CODE)
                    && !charCode.equals(DOT_CODE) && !charCode.equals(SPACE_CODE)) {
                throw new InvalidDataException();
            }
        }
        return characterMap;
    }

    @Override
    public List<String> findAnagrams(String word) {
        List<String> anagramsList = new ArrayList<>();
        /*List<String> dictionaryWords = dictionary.getWordsByLength(word);

        for (String dictionaryWord : dictionaryWords) {
            if (isAnagram(word, dictionaryWord)) {
                anagramsList.add(dictionaryWord);
            }
        }*/
        return anagramsList;
    }
}
