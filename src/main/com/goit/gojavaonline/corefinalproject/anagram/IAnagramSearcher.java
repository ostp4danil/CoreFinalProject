package main.com.goit.gojavaonline.corefinalproject.anagram;

import java.util.List;

public interface IAnagramSearcher {
    boolean areAnagrams(final String firstWord, final String secondWord);

    List<String> findAnagrams(final String word);
}
