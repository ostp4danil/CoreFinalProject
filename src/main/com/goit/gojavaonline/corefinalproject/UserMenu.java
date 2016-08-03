package main.com.goit.gojavaonline.corefinalproject;

import main.com.goit.gojavaonline.corefinalproject.anagram.AnagramSearcher;
import main.com.goit.gojavaonline.corefinalproject.dictionary.Dictionary;
import main.com.goit.gojavaonline.corefinalproject.read.ConsoleInput;
import main.com.goit.gojavaonline.corefinalproject.read.FileInput;
import main.com.goit.gojavaonline.corefinalproject.read.IInput;
import main.com.goit.gojavaonline.corefinalproject.write.ConsoleOutput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Danil-MAC on 8/3/16.
 */
public class UserMenu {

    private IInput consoleInput = new ConsoleInput();
    ConsoleOutput consoleOutput = new ConsoleOutput();


    private void printHelloMessage() {
        System.out.println("Hello! You are in the anagram searching tool!");
        System.out.println("Choose what you want to do:");
    }

    private void printOptions() {
        System.out.println("-wc to check words for anagrammatical");
        System.out.println("-sc to check sentences for anagrammatical");
        System.out.println("-fd to find anagrams for word in dictionary");
        System.out.println("-q to exit application");
    }

    private void runLinesChecker(String lineType) throws IOException {
        System.out.printf("First " + lineType + ":");
        String word1 = consoleInput.readString();
        System.out.printf("Second " + lineType + ":");
        String word2 = consoleInput.readString();
        AnagramSearcher anagramSearcher = new AnagramSearcher();
        System.out.println(anagramSearcher.areAnagrams(word1, word2));
    }

    private void runSearchingInDictionary() throws IOException {
        Dictionary dictionary = new Dictionary(readDictionary());
        AnagramSearcher anagramSearcher = new AnagramSearcher(dictionary);
        System.out.println("Word to search anagrams: ");
        String word = consoleInput.readString();
        consoleOutput.write(anagramSearcher.findAnagrams(word));
    }

    private List<String> readDictionary() throws IOException {
        List<String> fileData = new ArrayList<>();
        IInput fileInput;
        for (int i = 1; i <= 3; i++) {
            String fileName = "English" + i + ".txt";
            fileInput = new FileInput(fileName);
            fileData.addAll(fileInput.read());
        }
        return fileData;
    }

    public void showMenu() throws IOException {
        printHelloMessage();
        printOptions();
        String choose = "";
        while (!choose.equals("-q")) {
            choose = consoleInput.readString();
            switch (choose) {
                case ("-help"):
                    printOptions();
                    break;
                case ("-wc"):
                    runLinesChecker("word");
                    break;
                case ("-sc"):
                    runLinesChecker("sentence");
                    break;
                case ("-fd"):
                    runSearchingInDictionary();
                    break;
                case ("-q"):
                    break;
                default:
                    System.out.println("Wrong choose! Write -help for get help");
                    break;
            }
        }

    }
}
