import java.util.Scanner;

public class Main {
    public static final int OFFSET = 1000;

    public static void main(String[] args) {
        // Initialize grid
        boolean[][] grid = new boolean[2001][2001];
        
        Scanner sc = new Scanner(System.in);
        
        // Read coordinates of the first rectangle
        int x1 = sc.nextInt() + OFFSET;
        int y1 = sc.nextInt() + OFFSET;
        int x2 = sc.nextInt() + OFFSET;
        int y2 = sc.nextInt() + OFFSET;
        
        // Read coordinates of the second rectangle
        int x3 = sc.nextInt() + OFFSET;
        int y3 = sc.nextInt() + OFFSET;
        int x4 = sc.nextInt() + OFFSET;
        int y4 = sc.nextInt() + OFFSET;

        // Mark the area covered by the first rectangle as true
        for(int i = x1; i < x2; i++) {
            for(int j = y1; j < y2; j++) {
                grid[i][j] = true;
            }
        }

        // Mark the area covered by the second rectangle as false
        for(int i = x3; i < x4; i++) {
            for(int j = y3; j < y4; j++) {
                if (i >= x1 && i < x2 && j >= y1 && j < y2) {
                    grid[i][j] = false;
                }
            }
        }

        // Check if there are any remaining debris from the first rectangle
        boolean remainingDebris = false;
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (grid[i][j]) {
                    remainingDebris = true;
                    break;
                }
            }
            if (remainingDebris) {
                break;
            }
        }

        // If there are no remaining debris, the minimum covering rectangle area is 0
        if (!remainingDebris) {
            System.out.println(0);
            return;
        }

        // Find the minimum rectangle area to cover the remaining debris of the first rectangle
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]) {
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }

        // Calculate the area of the minimum covering rectangle
        int area = (maxX - minX + 1) * (maxY - minY + 1);

        System.out.println(area);
    }
}