import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] nums = new int[n];
        
        // Read the array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        
        int count = 0;
        
        // Iterate over all possible subarrays
        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int end = start; end < n; end++) {
                sum += nums[end];
                double average = (double) sum / (end - start + 1);
                
                // Check if the average matches any element in the current subarray
                for (int k = start; k <= end; k++) {
                    if (average == nums[k]) {
                        count++;
                        break; // No need to check further, move to next subarray
                    }
                }
            }
        }
        
        System.out.println(count);
        
        sc.close();
    }
}