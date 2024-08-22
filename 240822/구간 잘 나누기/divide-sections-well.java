import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] nums = new int[n];
        int totalSum = 0;
        int maxNum = 0;

        // Reading input and calculating the total sum and maximum number
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            totalSum += nums[i];
            maxNum = Math.max(maxNum, nums[i]);
        }

        // Binary search boundaries
        int left = maxNum;
        int right = totalSum;
        int result = totalSum;

        // Binary search for the minimum maximum sum of the segments
        while (left <= right) {
            int mid = (left + right) / 2;

            // Check if we can divide into m or fewer segments with the current mid as the maximum sum
            if (canDivide(nums, n, m, mid)) {
                result = mid;  // If possible, store the result and try to minimize further
                right = mid - 1;
            } else {
                left = mid + 1;  // If not possible, try larger mid values
            }
        }

        System.out.println(result);
    }

    // Helper function to check if we can divide the array into m or fewer segments with maxSum as the maximum sum
    public static boolean canDivide(int[] nums, int n, int m, int maxSum) {
        int currentSum = 0;
        int count = 1;

        for (int i = 0; i < n; i++) {
            if (currentSum + nums[i] > maxSum) {
                count++;  // Start a new segment
                currentSum = nums[i];

                // If the number of segments exceeds m, return false
                if (count > m) {
                    return false;
                }
            } else {
                currentSum += nums[i];
            }
        }

        return true;  // Successfully divided the array into m or fewer segments
    }
}