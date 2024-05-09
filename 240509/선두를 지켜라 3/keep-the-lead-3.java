import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read input values N and M
        int N = sc.nextInt(); // Number of movements for A
        int M = sc.nextInt(); // Number of movements for B
        
        // Read movement information for A
        int totalTimeA = 0;
        int[] arrA = new int[1000];
        for(int i = 0; i < N; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();
            for(int j = 0; j < t; j++) {
                arrA[totalTimeA++] = v;
            }
        }
        
        // Read movement information for B
        int totalTimeB = 0;
        int[] arrB = new int[1000];
        for(int i = 0; i < M; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();
            for(int j = 0; j < t; j++) {
                arrB[totalTimeB++] = v;
            }
        }
        
        // Count the number of times their positions change
        int changes = 0;
        int prevDiff = 0;
        for(int i = 0; i < Math.min(totalTimeA, totalTimeB); i++) {
            int diff = arrA[i] - arrB[i];
            if (diff != prevDiff) {
                changes++;
                prevDiff = diff;
            }
        }
        
        // Output the result
        System.out.println(changes);
    }
}