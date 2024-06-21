import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner sc = new Scanner(System.in);
        
        // Read the number of elements
        int n = sc.nextInt();
        
        // Read the list of numbers
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        
        // Initialize the variable to keep track of the maximum sum
        int maxSum = 0;
        
        // Iterate over each possible pair of non-adjacent elements
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 2; j < n; j++) {
                int sum = numbers[i] + numbers[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        
        // Print the maximum sum
        System.out.println(maxSum);
    }
}