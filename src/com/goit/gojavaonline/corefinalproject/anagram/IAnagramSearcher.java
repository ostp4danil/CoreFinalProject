package com.goit.gojavaonline.corefinalproject.anagram;

import java.util.List;

public interface IAnagramSearcher {
    boolean isAnagram(final String firstWord, final String secondWord);

    List<String> findAnagrams(final String word);
}
