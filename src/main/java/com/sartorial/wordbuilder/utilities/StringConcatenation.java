package com.sartorial.wordbuilder.utilities;

import java.util.ArrayList;

public class StringConcatenation {

    public static String concatenateList(ArrayList<String> words) {
        StringBuilder output = new StringBuilder();

        for(String word : words) output.append(word);

        return output.toString();
    }
}
