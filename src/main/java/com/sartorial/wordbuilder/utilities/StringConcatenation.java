package com.sartorial.wordbuilder.utilities;

import java.util.ArrayList;

public class StringConcatenation {

    private static final String[] HEXES = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String concatenateList(ArrayList<String> words) {
        StringBuilder output = new StringBuilder();

        for(String word : words) output.append(word);

        return output.toString();
    }

    public static String toHexString(final byte[] data) {
        String hex;

        if (data == null) {
            hex = "null";
        } else {
            StringBuilder sb = new StringBuilder();
            for (byte b : data) {
                int lower = b & 0x0f;
                int upper = (b >> 4) & 0x0f;

                sb.append(HEXES[upper]);
                sb.append(HEXES[lower]);
            }
            hex = sb.toString();
        }

        return hex;
    }
}
