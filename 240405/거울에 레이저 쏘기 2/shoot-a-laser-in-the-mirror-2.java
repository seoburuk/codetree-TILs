import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the size of the grid
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        // Initialize the grid to store mirror information
        char[][] grid = new char[n][n];
        
        // Read the grid configuration
        for (int i = 0; i < n; i++) {
            String row = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = row.charAt(j);
            }
        }
        
        // Read the starting position of the laser beam
        int start = scanner.nextInt();
        
        // Calculate the starting position coordinates based on the start index
        int x, y;
        if (start <= n) {
            x = 0;
            y = start - 1;
        } else if (start <= 2 * n) {
            x = start - n - 1;
            y = n - 1;
        } else if (start <= 3 * n) {
            x = n - 1;
            y = 3 * n - start;
        } else {
            x = 4 * n - start;
            y = 0;
        }
        
        // Define directions: down, left, up, right (clockwise)
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        
        // Initialize the number of reflections
        int reflections = 0;
        
        // Simulate the path of the laser beam
        while (x >= 0 && x < n && y >= 0 && y < n) {
            // Check if the current cell contains a mirror
            if (grid[x][y] == '/') {
                // Mirror direction depends on the direction of the beam
                if (dx[0] == 0) { // Beam moving horizontally
                    int temp = dx[0];
                    dx[0] = -dy[0];
                    dy[0] = -temp;
                } else { // Beam moving vertically
                    int temp = dx[0];
                    dx[0] = dy[0];
                    dy[0] = temp;
                }
            } else if (grid[x][y] == '\\') {
                // Mirror direction depends on the direction of the beam
                if (dx[0] == 0) { // Beam moving horizontally
                    int temp = dx[0];
                    dx[0] = dy[0];
                    dy[0] = temp;
                } else { // Beam moving vertically
                    int temp = dx[0];
                    dx[0] = -dy[0];
                    dy[0] = -temp;
                }
            }
            
            // Move the beam to the next cell
            x += dx[0];
            y += dy[0];
            
            // Increment the number of reflections
            reflections++;
        }
        
        // Print the number of reflections
        System.out.println(reflections);
        
        // Close the scanner
        scanner.close();
    }
}