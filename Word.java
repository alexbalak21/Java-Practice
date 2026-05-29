import java.util.List;

public class Word {

    public static String mostFrequentWord(List<String> words) {
        int[] counts = new int[words.size()];
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.size(); j++) {
                if (i == j)
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
        List<String> list = new java.util.ArrayList<>(List.of("apple", "banana", "apple", "orange", "banana", "apple"));
        String mostFrequent = mostFrequentWord(list);
        System.out.println(mostFrequent);
    }

}