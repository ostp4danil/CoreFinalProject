package test.com.goit.gojavaonline.corefinalproject.anagram;

import main.com.goit.gojavaonline.corefinalproject.anagram.AnagramSearcher;
import main.com.goit.gojavaonline.corefinalproject.dictionary.Dictionary;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AnagramSearcherTest {

    @Test(timeout = 1000)
    public void isAnagram() throws Exception {
        String firstWord = "lake";
        String secondWord = "leak";

        boolean expected = true;

        AnagramSearcher searcher = new AnagramSearcher();
        boolean result = searcher.areAnagrams(firstWord,secondWord);

        assertEquals(expected,result);
    }

    @Test(timeout = 1000)
    public void isAnagram_WhenOneWordIsEmptyThenReturnsFalse() throws Exception {
        String firstWord = "";
        String secondWord = "word";

        boolean expected = false;

        AnagramSearcher searcher = new AnagramSearcher();
        boolean result = searcher.areAnagrams(firstWord,secondWord);

        assertEquals(expected,result);
    }

    @Test(timeout = 1000)
    public void isAnagram_WhenTwoWordsAreEmptyThenReturnsTrue() throws Exception {
        String firstWord = "";
        String secondWord = "";

        boolean expected = true;

        AnagramSearcher searcher = new AnagramSearcher();
        boolean result = searcher.areAnagrams(firstWord,secondWord);

        assertEquals(expected,result);
    }

    @Test(timeout = 1000)
    public void isAnagram_WhenWordsNotEqualInSentenceSignsQuantityThenReturnsFalse() throws Exception {
        String firstWord = "example,,";
        String secondWord = "example,";

        boolean expected = false;

        AnagramSearcher searcher = new AnagramSearcher();
        boolean result = searcher.areAnagrams(firstWord,secondWord);

        assertEquals(expected,result);
    }

    @Test(timeout = 1000)
    public void isAnagram_WhenWordsAreAnagramsButNotEqualInSpacesQuantityThenReturnsTrue() throws Exception {
        String firstWord = "word   ";
        String secondWord = "word";

        boolean expected = true;

        AnagramSearcher searcher = new AnagramSearcher();
        boolean result = searcher.areAnagrams(firstWord,secondWord);

        assertEquals(expected,result);
    }

    @Test(timeout = 1000)
    public void findAnagrams() throws Exception {
        String word = "lake";
        List<String> wordsList = new ArrayList<>();
        wordsList.add("leak");
        wordsList.add("keal");
        wordsList.add("ealk");
        wordsList.add("another");
        Dictionary dictionary = new Dictionary(wordsList);
        AnagramSearcher searcher = new AnagramSearcher(dictionary);

        List<String> expected = new ArrayList<>();
        expected.add("leak");
        expected.add("keal");
        expected.add("ealk");

        List<String> result=searcher.findAnagrams(word);

        assertEquals(expected,result);
    }

    @Test(timeout = 1000)
    public void findAnagrams_WhenThereNotDictionaryThenReturnsEmptyList() throws Exception {
        String word = "word";
        AnagramSearcher searcher = new AnagramSearcher();
        List<String> expected = new ArrayList<>();

        List<String> result=searcher.findAnagrams(word);

        assertEquals(expected,result);
    }

    @Test(timeout = 1000)
    public void findAnagrams_WhenDictionaryHasNotAnagramsThenReturnsEmptyList() throws Exception {
        String word = "word";
        List<String> wordsList = new ArrayList<>();
        wordsList.add("letter");
        Dictionary dictionary = new Dictionary(wordsList);
        AnagramSearcher searcher = new AnagramSearcher(dictionary);

        List<String> expected = new ArrayList<>();

        List<String> result=searcher.findAnagrams(word);

        assertEquals(expected,result);
    }


    @Test(timeout = 1000)
    public void findAnagrams_WhenWordHasNonAlphabeticalCharThenReturnsEmptyList() throws Exception {
        String word = "word8";
        List<String> wordsList = new ArrayList<>();
        wordsList.add("word");
        Dictionary dictionary = new Dictionary(wordsList);
        AnagramSearcher searcher = new AnagramSearcher(dictionary);

        List<String> expected = new ArrayList<>();

        List<String> result=searcher.findAnagrams(word);

        assertEquals(expected,result);
    }
}