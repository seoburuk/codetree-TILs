import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] =sc.nextInt();
            }
        }
        int maxCoins = 0;
        for(int i = 0; i < n-2; i++) {
            for(int j = 0; j <n-2; j++) {
                maxCoins = Math.max(findCoins(grid,i,j), maxCoins);
            }
        }

        System.out.print(maxCoins);
    }
    public static int findCoins(int grid[][], int startX,int startY) {
        int cnt = 0;
        for(int i = startX; i < startX+3; i++) {
            for(int j = startY; j < startY+3; j++) {
                cnt += grid[i][j];
            }
        }
        return cnt;
    }
}