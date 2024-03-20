import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the number of rectangles
        int N = sc.nextInt();
        
        // Initialize a boolean grid to represent the plane
        boolean[][] grid = new boolean[201][201];
        
        // Iterate through each rectangle
        for (int i = 0; i < N; i++) {
            // Read the coordinates of the current rectangle
            int x1 = sc.nextInt() + 100; // Adjust for negative coordinates
            int y1 = sc.nextInt() + 100; // Adjust for negative coordinates
            int x2 = sc.nextInt() + 100; // Adjust for negative coordinates
            int y2 = sc.nextInt() + 100; // Adjust for negative coordinates
            
            // Mark all cells within the rectangle as covered
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    grid[x][y] = true;
                }
            }
        }
        
        // Calculate the total area by counting the covered cells
        int totalArea = 0;
        for (int x = 0; x < 201; x++) {
            for (int y = 0; y < 201; y++) {
                if (grid[x][y]) {
                    totalArea++;
                }
            }
        }
        
        // Print the total area
        System.out.println(totalArea);
    }
}