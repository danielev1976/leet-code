package edu.danielev.leet_code.string_manipulation;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class Sorter {

    public static int[] sortIntegers(int[] ints){
        if(ints == null) return null;
        Arrays.sort(ints);
        return ints;
    }
}
