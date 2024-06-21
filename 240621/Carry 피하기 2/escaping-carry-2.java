import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner sc = new Scanner(System.in);
        
        // Read the number of elements
        int n = sc.nextInt();
        int[] numbers = new int[n];
        
        // Read the numbers
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        
        // Variable to track the maximum sum
        int maxSum = -1;
        
        // Iterate over all combinations of three numbers
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (isCarryFree(numbers[i], numbers[j], numbers[k])) {
                        int sum = numbers[i] + numbers[j] + numbers[k];
                        if (sum > maxSum) {
                            maxSum = sum;
                        }
                    }
                }
            }
        }
        
        // Print the maximum sum
        System.out.println(maxSum);
    }
    
    // Function to check if the sum of three numbers is carry-free
    public static boolean isCarryFree(int a, int b, int c) {
        int carry = 0;
        while (a > 0 || b > 0 || c > 0) {
            int sum = (a % 10) + (b % 10) + (c % 10) + carry;
            if (sum >= 10) {
                return false;
            }
            carry = sum / 10;
            a /= 10;
            b /= 10;
            c /= 10;
        }
        return true;
    }
}