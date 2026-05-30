import java.util.HashSet;
import java.util.Set;

public class Exercise {

    public static int findFirstDuplicate(int[] numbers) {
        Set<Integer> seenNumbers = new HashSet<>();
        seenNumbers.add(numbers[0]);
        int duplicateValue = -1;

        for (int i = 1; i < numbers.length; i++) {
            if (seenNumbers.contains(numbers[i])) {
                duplicateValue = numbers[i];
                break;
            } else
                seenNumbers.add(numbers[i]);
        }
        return duplicateValue;
    }

    public static int correct_findFirstDuplicate(int[] numbers) {
        Set<Integer> seen = new HashSet<>();

        for (int n : numbers) {
            if (seen.contains(n)) {
                return n; // first duplicate found
            }
            seen.add(n);
        }

        return -1; // no duplicates
    }

    public static void main(String[] args) {
        int[] values = {
    4, 7, 1, 9, 3, 7, 8, 2, 5, 6,
    10, 12, 14, 3, 18, 20, 22, 24, 26, 28,
    30, 32, 34, 36, 38, 40, 42, 44, 46, 48,
    50, 52, 54, 56, 58, 60, 62, 64, 66, 68,
    70, 72, 74, 76, 78, 80, 82, 84, 86, 88
};


        int duplicateValue = findFirstDuplicate(values);
        System.out.println(duplicateValue);
    }

}
