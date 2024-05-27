package edu.danielev.leet_code.string_manipulation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverserTest {

    @Test
    void reverseString() {
        String reversedString = "aom";
        assertEquals(reversedString, Reverser.reverseString("moa"));
    }

    @Test
    void reverseWords() {
        String reversedSentence = "you with be force the may";
        assertEquals(reversedSentence, Reverser.reverseWords("may the force be with you"));
    }
}