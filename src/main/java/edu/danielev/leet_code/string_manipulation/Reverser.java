package edu.danielev.leet_code.string_manipulation;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class Reverser {

    public static String reverseString(String s) {
        if(s.isEmpty()) return s;
        return new StringBuilder(s).reverse().toString();
    }

    public static String reverseWords(String s) {
        if(s.isEmpty()) return s;
        List<String> words = new ArrayList<>(Arrays.asList(s.split(" ")));
        Collections.reverse(words);
        return String.join(" ", words);
    }
}
