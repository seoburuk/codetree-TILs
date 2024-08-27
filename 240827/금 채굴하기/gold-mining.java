import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int maxGold = 0;

        // 모든 격자 위치를 마름모의 중심으로 삼아서 탐색
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                // 가능한 모든 K값에 대해 탐색
                for (int k = 0; k <= 20; k++) {
                    int goldCount = 0;

                    // 마름모 영역 내에서 금을 카운팅
                    for (int i = -k; i <= k; i++) {
                        for (int j = -(k - Math.abs(i)); j <= (k - Math.abs(i)); j++) {
                            int nx = x + i;
                            int ny = y + j;

                            // 범위 내에 있는지 체크하고 금이 있는지 확인
                            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                                goldCount += grid[nx][ny];
                            }
                        }
                    }

                    // 비용 계산
                    int operationCost = k * k + (k + 1) * (k + 1);
                    int revenue = goldCount * m;

                    // 손해 보지 않는 경우만 고려하여 최대 금 개수를 갱신
                    if (revenue >= operationCost) {
                        maxGold = Math.max(maxGold, goldCount);
                    }
                }
            }
        }

        // 최대로 캘 수 있는 금의 개수를 출력
        System.out.println(maxGold);
    }
}