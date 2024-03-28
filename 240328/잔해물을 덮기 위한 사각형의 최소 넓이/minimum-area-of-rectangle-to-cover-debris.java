import java.util.Scanner;

public class Main {
    public static final int offset = 1000;

    public static void main(String[] args) {
        // Initialize grid
        boolean[][] grid = new boolean[2001][2001];
        
        Scanner sc = new Scanner(System.in);
        
        // Read coordinates of the first rectangle
        int x1 = sc.nextInt() + offset;
        int y1 = sc.nextInt() + offset;
        int x2 = sc.nextInt() + offset;
        int y2 = sc.nextInt() + offset;
        
        // Read coordinates of the second rectangle
        int x3 = sc.nextInt() + offset;
        int y3 = sc.nextInt() + offset;
        int x4 = sc.nextInt() + offset;
        int y4 = sc.nextInt() + offset;

        // Mark the area covered by the first rectangle as true
        for(int i = x1; i < x2; i++) {
            for(int j = y1; j < y2; j++) {
                grid[i][j] = true;
            }
        }

        // Mark the area covered by the second rectangle as false
        for(int i = x3; i < x4; i++) {
            for(int j = y3; j < y4; j++) {
                grid[i][j] = false;
            }
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