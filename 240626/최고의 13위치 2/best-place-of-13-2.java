import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int maxCoins = 0;

        // 첫 번째 1x3 격자를 가로로 놓는 모든 위치를 탐색합니다.
        for (int x1 = 0; x1 < n; x1++) {
            for (int y1 = 0; y1 <= n - 3; y1++) {
                int coins1 = grid[x1][y1] + grid[x1][y1 + 1] + grid[x1][y1 + 2];

                // 두 번째 1x3 격자를 가로로 놓는 모든 위치를 탐색합니다.
                for (int x2 = x1+1; x2 < n; x2++) {
                    for (int y2 = 0; y2 <= n - 3; y2++) {
                        // 두 격자가 겹치지 않는지 확인합니다.
                        if (!(x1 == x2 && (y1 == y2 || y1 + 1 == y2 || y1 + 2 == y2))) {
                            int coins2 = grid[x2][y2] + grid[x2][y2 + 1] + grid[x2][y2 + 2];
                            maxCoins = Math.max(maxCoins, coins1 + coins2);
                        }
                    }
                }
            }
        }

        System.out.println(maxCoins);
    }
}