import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] people = new int[6];
        int totalSum = 0;

        for (int i = 0; i < 6; i++) {
            people[i] = sc.nextInt();
            totalSum += people[i];
        }

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    if (k == i || k == j) continue;
                    for (int l = k + 1; l < 6; l++) {
                        if (l == i || l == j) continue;
                        
                        // Choose the remaining two
                        for (int m = 0; m < 6; m++) {
                            if (m == i || m == j || m == k || m == l) continue;
                            for (int n = m + 1; n < 6; n++) {
                                if (n == i || n == j || n == k || n == l) continue;

                                // Calculate the sums of the three teams
                                int sum1 = people[i] + people[j];
                                int sum2 = people[k] + people[l];
                                int sum3 = people[m] + people[n];

                                // Calculate the current difference
                                int maxSum = Math.max(sum1, Math.max(sum2, sum3));
                                int minSum = Math.min(sum1, Math.min(sum2, sum3));
                                int currentDiff = maxSum - minSum;

                                // Update the minimum difference
                                if (currentDiff < minDiff) {
                                    minDiff = currentDiff;
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(minDiff);
    }
}