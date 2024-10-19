package org.aktic.mostCommonWord;

import java.util.*;

public class Solution {
    public static String mostCommonWord(String paragraph, String[] banned) {
        // Step 1: Preprocess the paragraph
        paragraph = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
        String[] wordsArray = paragraph.split("\\s+");

        // Step 2: Add banned words to a set for fast lookup
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));


        // Step 3: Count word frequencies, ignoring banned words
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : wordsArray) {
            if (!bannedSet.contains(word)) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }



    public static void main(String[] args) {
        String paragraph = "s? Q, Q' q! F' U. X, U? g! p; X; U! u. z' z. r. u! Y? Z, m? X, T! z! S! X? s! h. q; W' u' W? T; o. U! w! U? o, y! l! u? Y' P. H? s! q; X' n' Y' R, X. e; u? u? x. w, s; p, W; x; Q. x. n' g. T. M; t, X! K' x, q? t. p. s! x. l? u' Q, r, t! Z? y? b! c? J; T? F. s' r? k, O! I! y? k! v; T' H; W, v; w, o, R? P. i' v! Z' c! Q? m! I; V; Z; y' v! w, u! y' Q? y, f! J! V! O; Y; T, L. r; i, K. q! s! y, O. R' a? T? l, R, m. N; q. j' t. Q! y; x; W' I! S' L, z! s; G; P! Z; X' V, w; G, y! x! T. H! T! x' M? L, S! S, y! Z. P; X! y; i. r' q; P! X' z' V? W? y! N; s; z, Z. r. Z, U! g. g, z! R, j, d? Y; z! s! V. W. p! Y! d! N' P. F. R. w. S; y? Z' r? Z, W! I, V! t' Z, Y' M? C, m; g? O? F. p' w? X. p; L' n; O? y' P. V? O. x. j! L! k. q' M. V. v. h; Y? N. P, J? u? I. Z? r, d! Z? n' U; w, Y. s? u; k! E. Z! i. t' l' E! h! V. x. t! r? Y. K' J; v? J; O' B? K; n. l, V' D. e; w! P; n? r. z? w? n' M. V' v? p; j; O! t' n! U! t! F' t, r. Q' W, M. R' N' S? E. w; q; t! o' U! O' x, j; V? n. u? Z! X? W, V; L; H! O! Z; Y;";
        String[] banned = {};
        System.out.println(mostCommonWord(paragraph, banned));
    }
}
