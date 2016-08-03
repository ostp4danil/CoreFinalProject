package test.com.goit.gojavaonline.corefinalproject.dictionary;

import com.goit.gojavaonline.corefinalproject.dictionary.Dictionary;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DictionaryTest {

    @Test(timeout = 1000)
    public void getWordsWithSameLength() throws Exception {
        List<String> wordsList = new ArrayList<>();
        wordsList.add("one");
        wordsList.add("two");
        wordsList.add("three");
        wordsList.add("four");
        Dictionary dictionary = new Dictionary(wordsList);

        List<String> result = dictionary.getWordsWithSameLength("one");

        List<String> expected = new ArrayList<>();
        expected.add("one");
        expected.add("two");

        assertEquals(expected, result);
    }

    @Test(timeout = 1000)
    public void getWordsWithSameLength_WhenGivenWordIsEmptyThenReturnsEmptyList() throws Exception {
        List<String> wordsList = new ArrayList<>();
        wordsList.add("one");
        wordsList.add("two");
        wordsList.add("three");
        wordsList.add("four");
        Dictionary dictionary = new Dictionary(wordsList);

        List<String> result = dictionary.getWordsWithSameLength("");

        List<String> expected = new ArrayList<>();

        assertEquals(expected, result);
    }

    @Test(timeout = 1000)
    public void getWordsWithSameLength_WhenDictionaryHadNotBeingFilledThenReturnsEmptyList() throws Exception {
        List<String> wordsList = new ArrayList<>();

        Dictionary dictionary = new Dictionary(wordsList);

        List<String> result = dictionary.getWordsWithSameLength("word");

        List<String> expected = new ArrayList<>();

        assertEquals(expected, result);
    }
}