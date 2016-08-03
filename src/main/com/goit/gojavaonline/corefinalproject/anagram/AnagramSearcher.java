package main.com.goit.gojavaonline.corefinalproject.anagram;

import main.com.goit.gojavaonline.corefinalproject.dictionary.Dictionary;
import com.sun.media.sound.InvalidDataException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnagramSearcher implements IAnagramSearcher {

    private Dictionary dictionary;

    public AnagramSearcher(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public AnagramSearcher() {
        this.dictionary = new Dictionary(new ArrayList<String>());
    }

    @Override
    public boolean areAnagrams(String firstWord, String secondWord) {
        Map<Character, Integer> characterMapOfFirstWord;
        Map<Character, Integer> characterMapOfSecondWord;
        char[] charsOfFirstWord = firstWord.toCharArray();
        char[] charsOfSecondWord = secondWord.toCharArray();

        characterMapOfFirstWord = recountCharsInWord(charsOfFirstWord);
        characterMapOfSecondWord = recountCharsInWord(charsOfSecondWord);

        return characterMapOfFirstWord.equals(characterMapOfSecondWord);
    }

    private Map<Character, Integer> recountCharsInWord(char[] chars) {
        Map<Character, Integer> characterMap = new TreeMap<>();
        for (char character : chars) {
            if (character != ' ') {
                if (characterMap.containsKey(character)) {
                    int count = characterMap.get(character);
                    characterMap.put(character, count + 1);
                } else {
                    characterMap.put(character, 1);
                }
            }
        }
        return characterMap;
    }

    @Override
    public List<String> findAnagrams(String word) {
        List<String> anagramsList = new ArrayList<>();
        List<String> dictionaryWords = dictionary.getWordsWithSameLength(word);

        for (String dictionaryWord : dictionaryWords) {
            if (areAnagrams(word, dictionaryWord)) {
                anagramsList.add(dictionaryWord);
            }
        }
        return anagramsList;
    }
}