import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        int cnt = 1;
        int row = 0;
        int col = 0;
        int dir = 0; // 0: right, 1: down, 2: left, 3: up
        
        while (cnt <= n * m) {
            matrix[row][col] = cnt++;
            int newRow = row + dy[dir];
            int newCol = col + dx[dir];
            
            // Check if the new position is valid and unoccupied
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && matrix[newRow][newCol] == 0) {
                row = newRow;
                col = newCol;
            } else {
                // Change direction
                dir = (dir + 1) % 4;
                row += dy[dir];
                col += dx[dir];
            }
        }
        
        // Print the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j]);
                if (j < m - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    
    // Define dy and dx for each direction (S, E, N, W)
    public static int[] dy = {1, 0, -1, 0};
    public static int[] dx = {0, 1, 0, -1};
}