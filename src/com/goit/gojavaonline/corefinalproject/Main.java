package com.goit.gojavaonline.corefinalproject;

import com.goit.gojavaonline.corefinalproject.anagramm.AnagramSearcher;
import com.goit.gojavaonline.corefinalproject.anagramm.IAnagramSearcher;

public class Main {

<<<<<<< HEAD
    public static void main(String[] args){

=======
    public static void main(String[] args) {
        IAnagramSearcher searcher = new AnagramSearcher();
        System.out.println(searcher.isAnagram("london, don don9  ","donlon don don9"));
>>>>>>> finalproject/vania
    }
}
