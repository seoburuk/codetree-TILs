import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int prev = sc.nextInt(); // Set the first number as the previous number
        int maxCount = 1; // Variable to store the maximum consecutive count
        int count = 1; // Variable to store the current consecutive count

        for (int i = 1; i < n; i++) {
            int current = sc.nextInt();
            if (current == prev) {
                count++; // Increase consecutive count if the current number is the same as the previous one
                maxCount = Math.max(maxCount, count); // Update the maximum consecutive count
            } else {
                count = 1; // Reset consecutive count if the current number is different from the previous one
            }
            prev = current; // Update the previous number
        }

        System.out.println(maxCount);
    }
}