import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of squares
        boolean[][] grid = new boolean[201][201]; // Initialize grid

        for(int i = 0; i < n; i++) {
            int x = sc.nextInt() + 100;
            int y = sc.nextInt() + 100; // Adjust coordinates to fit grid

            for(int j = x; j < x + 8; j++) {
                for(int k = y; k < y + 8; k++) {
                    grid[j][k] = true; // Make square as coverd
                }
            }
        }

        int totalArea = 0;
        for(int i = 0 ; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]) {
                    totalArea++;
                }
            }
        }
        System.out.print(totalArea);

        // 여기에 코드를 작성해주세요.
    }
}