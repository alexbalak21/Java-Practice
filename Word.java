import java.util.ArrayList;
import java.util.List;

public class Word {

    public static String mostFrequentWord(List<String> words) {
        words = new ArrayList<>(words);
        int[] counts = new int[words.size()];
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.size(); j++) {
                if (i == j || words.get(j).isEmpty())
                    continue;
                if (words.get(i) == words.get(j)) {
                    counts[i]++;
                    words.set(j, "");
                }
            }
        }
        int maxIndex = 0;
        for (int i = 0; i < counts.length; i++)
            if (counts[i] > counts[maxIndex])
                maxIndex = i;

        return words.get(maxIndex);
    }

    public static void main(String[] args) {
        List<List<String>> tests = List.of(
                List.of("apple", "banana", "apple", "orange", "banana", "apple"), // expected: apple
                List.of("dog", "cat", "dog", "cat"), // expected: cat
                List.of("x", "y", "z", "y", "z", "z"), // expected: z
                List.of("java", "java", "react", "react", "react", "java", "spring"), // expected: java
                List.of("one"), // expected: one
                List.of("a", "b", "c", "d", "e", "f", "a", "b", "a"), // expected: a
                List.of("lion", "tiger", "bear", "lion", "bear", "bear"), // expected: bear
                List.of("aaa", "aa", "a", "aa", "aaa", "a", "a"), // expected: a
                List.of("blue", "blue", "red", "green", "green", "green", "red", "red"), // expected: green
                List.of("alex", "alex", "alex", "balakirev", "balakirev") // expected: alex
        );

        for (List<String> test : tests) {
            System.out.println(mostFrequentWord(test));
        }
    }
}