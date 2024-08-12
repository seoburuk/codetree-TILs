import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] segments = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
        }
        
        // Calculate the global maxStart and minEnd
        int globalMaxStart = Integer.MIN_VALUE;
        int globalMinEnd = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            globalMaxStart = Math.max(globalMaxStart, segments[i][0]);
            globalMinEnd = Math.min(globalMinEnd, segments[i][1]);
        }
        
        // Check for each segment being removed
        for (int i = 0; i < n; i++) {
            int currentMaxStart = Integer.MIN_VALUE;
            int currentMinEnd = Integer.MAX_VALUE;
            
            // Calculate maxStart and minEnd without segment i
            for (int j = 0; j < n; j++) {
                if (i == j) continue; // Skip the segment being "removed"
                currentMaxStart = Math.max(currentMaxStart, segments[j][0]);
                currentMinEnd = Math.min(currentMinEnd, segments[j][1]);
            }
            
            // Check if there is an overlapping region after removing segment i
            if (currentMaxStart <= currentMinEnd) {
                System.out.println("Yes");
                return;
            }
        }
        
        // If no such segment found
        System.out.println("No");
    }
}