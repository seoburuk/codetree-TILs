import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input
        int N = scanner.nextInt();
        String s = scanner.next();

        System.out.println(findMinimumUniqueLength(N, s));
    }

    public static int findMinimumUniqueLength(int N, String s) {
        // Iterate over possible substring lengths
        for (int length = 1; length <= N; length++) {
            HashSet<String> seenSubstrings = new HashSet<>();
            boolean foundDuplicate = false;

            // Slide window over the string
            for (int i = 0; i <= N - length; i++) {
                String substring = s.substring(i, i + length);
                if (seenSubstrings.contains(substring)) {
                    foundDuplicate = true;
                    break;
                }
                seenSubstrings.add(substring);
            }

            // If no duplicates were found for this length, return it
            if (!foundDuplicate) {
                return length;
            }
        }

        // If all lengths up to N have duplicates, the entire string is unique
        return N;
    }
}