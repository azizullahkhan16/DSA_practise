package org.aktic.isValid;

public class Solution {
    public static boolean isValid(String word) {
        if (word.length() < 3) return false;

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (char c : word.toCharArray()) {
            if (IsDigitOrLetter(c)) {
                if (!hasVowel && IsVowel(c)) hasVowel = true;
                else if (!hasConsonant && IsConsonant(c)) hasConsonant = true;
            } else return false;
        }

        return hasVowel && hasConsonant;
    }

    public static boolean IsVowel(char c) {
        // Convert to lowercase for case-insensitive comparison
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static boolean IsConsonant(char c) {
        c = Character.toLowerCase(c);
        return Character.isLetter(c) && !(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    public static boolean IsDigitOrLetter(char c) {
        return Character.isDigit(c) || Character.isLetter(c);
    }
}
