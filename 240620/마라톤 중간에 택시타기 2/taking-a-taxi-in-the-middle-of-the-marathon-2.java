import java.util.Scanner;

public class Main {
    // Method to calculate Manhattan distance between two points
    public static int calculateDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] checkpoints = new int[n][2];

        for (int i = 0; i < n; i++) {
            checkpoints[i][0] = sc.nextInt();
            checkpoints[i][1] = sc.nextInt();
        }

        int totalDistance = 0;
        for (int i = 0; i < n - 1; i++) {
            totalDistance += calculateDistance(checkpoints[i], checkpoints[i + 1]);
        }

        // Calculate the minimum distance by skipping one checkpoint (not the first or last)
        int minDistance = totalDistance;
        for (int i = 1; i < n - 1; i++) {
            int distanceWithSkip = totalDistance 
                                    - calculateDistance(checkpoints[i - 1], checkpoints[i])
                                    - calculateDistance(checkpoints[i], checkpoints[i + 1])
                                    + calculateDistance(checkpoints[i - 1], checkpoints[i + 1]);

            if (minDistance > distanceWithSkip) {
                minDistance = distanceWithSkip;
            }
        }

        System.out.println(minDistance);
        sc.close();
    }
}