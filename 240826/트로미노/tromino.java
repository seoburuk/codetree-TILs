import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 격자의 크기 n과 m 입력받기
        int n = sc.nextInt();
        int m = sc.nextInt();

        // n * m 크기의 격자 입력받기
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int maxSum = 0;

        // 모든 칸을 탐색하면서 최대 합 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 1. 가로 막대 블럭 확인
                if (j + 2 < m) {
                    int sum = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
                    maxSum = Math.max(maxSum, sum);
                }

                // 2. 세로 막대 블럭 확인
                if (i + 2 < n) {
                    int sum = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];
                    maxSum = Math.max(maxSum, sum);
                }

                // 3. L자 모양 블럭 확인 (4가지 방향)
                if (i + 1 < n && j + 1 < m) {
                    // L자 모양 (원래)
                    int sum = grid[i][j] + grid[i][j + 1] + grid[i + 1][j];
                    maxSum = Math.max(maxSum, sum);

                    // L자 모양 (회전)
                    sum = grid[i][j] + grid[i + 1][j] + grid[i + 1][j + 1];
                    maxSum = Math.max(maxSum, sum);

                    // L자 모양 (뒤집기)
                    sum = grid[i + 1][j] + grid[i + 1][j + 1] + grid[i][j + 1];
                    maxSum = Math.max(maxSum, sum);

                    // L자 모양 (반대 회전)
                    sum = grid[i][j] + grid[i + 1][j] + grid[i][j + 1];
                    maxSum = Math.max(maxSum, sum);
                }
            }
        }

        // 최대 합 출력
        System.out.println(maxSum);
    }
}