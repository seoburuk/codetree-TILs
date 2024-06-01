import java.io.*;
import java.util.*;

public class Main {
    public static int R, C;
    public static int W = 0, B = 1;
    public static int[][] grid;
    public static int answer = 0;
    public static int currR = 0, currC = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        grid = new int[R][C];
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                char color = sc.next().charAt(0);
                if (color == 'W')
                    grid[row][col] = W;
                else
                    grid[row][col] = B;
            }
        }

        simulate(0, 0, 0, grid[0][0]);
        System.out.println(answer);
    }

    public static void simulate(int count, int r, int c, int val) {

        if (r == R-1 && c == C-1) {
            if (count == 3)
                answer++;
            return;
        }

        for (int nrow = r+1; nrow < R; nrow++) {
            for (int ncol = c+1; ncol < C; ncol++) {
                if (grid[r][c] != grid[nrow][ncol]) {
                    simulate(count+1, nrow, ncol, grid[nrow][ncol]);
                }
            }
        }
    }
}