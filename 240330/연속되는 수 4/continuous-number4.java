import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n]; // Fixed array initialization

        // Reading the input numbers
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int maxLength = 1; // Fixed initialization to handle case when n = 1
        int current = 1;

        // Iterating through the array to find the length of the longest increasing continuous subsequence
        for (int i = 1; i < n; i++) { // Fixed loop condition
            if (a[i] > a[i - 1]) {
                current++;
            } else {
                maxLength = Math.max(current, maxLength);
                current = 1;
            }
        }

        // Check if the currentLength at the end of the array is greater than maxLength
        maxLength = Math.max(maxLength, current);

        // Output the result
        System.out.print(maxLength);
    }
}