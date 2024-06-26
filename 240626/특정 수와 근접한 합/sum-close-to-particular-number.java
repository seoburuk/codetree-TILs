import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of integers
        int s = sc.nextInt(); // Target sum
        int[] num = new int[n]; // Array to store integers

        // Read the array of integers
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        int minDif = Integer.MAX_VALUE;

        // Iterate through all pairs (i, j) where i != j
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = 0;
                // Calculate sum excluding num[i] and num[j]
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        sum += num[k];
                    }
                }
                // Calculate current difference from target sum s
                int currDif = Math.abs(s - sum);
                // Update minimum difference found
                minDif = Math.min(minDif, currDif);
            }
        }

        // Output the minimum difference found
        System.out.println(minDif);

        sc.close();
    }
}