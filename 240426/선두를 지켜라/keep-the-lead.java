import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        // Arrays to store distances
        int[] distance_A = new int[n];
        int[] distance_B = new int[m];
        
        // Read A's distances
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();
            distance_A[i] = v * t;
        }
        
        // Read B's distances
        for (int i = 0; i < m; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();
            distance_B[i] = v * t;
        }
        
        // Count lead changes
        int lead_changes = -1;
        int ahead = 0;  // 0 for tie, 1 for A ahead, -1 for B ahead
        int minIterations = Math.min(n, m);
        for (int i = 0; i < minIterations; i++) {
            if (distance_A[i] > distance_B[i]) {
                if (ahead != 1) {
                    ahead = 1;
                    lead_changes++;
                }
            } else if (distance_A[i] < distance_B[i]) {
                if (ahead != -1) {
                    ahead = -1;
                    lead_changes++;
                }
            }
        }
        
        // Print the number of lead changes
        System.out.println(lead_changes);
    }
}