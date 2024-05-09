import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read input values N and M
        int N = sc.nextInt(); // Number of movements for A
        int M = sc.nextInt(); // Number of movements for B
        
        // Read movement information for A
        int[] arrA = new int[1001]; // Increase the array size to accommodate potential time differences
        int totalTimeA = 0;
        for(int i = 0; i < N; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();
            for(int j = 0; j < t; j++) {
                arrA[totalTimeA++] = v;
            }
        }
        
        // Read movement information for B
        int[] arrB = new int[1001]; // Increase the array size to accommodate potential time differences
        int totalTimeB = 0;
        for(int i = 0; i < M; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();
            for(int j = 0; j < t; j++) {
                arrB[totalTimeB++] = v;
            }
        }
        
        // Count the number of times their positions change
        int changes = 0;
        int currA = 0;
        int currB = 0;
        for(int i = 0; i < Math.max(totalTimeA, totalTimeB); i++) {
            if (i < totalTimeA) currA += arrA[i];
            if (i < totalTimeB) currB += arrB[i];
            if (currA != currB) {
                changes++;
                currA = currB = 0; // Reset positions to start comparing from the next moment
            }
        }
        
        // Output the result
        System.out.println(changes);
    }
}