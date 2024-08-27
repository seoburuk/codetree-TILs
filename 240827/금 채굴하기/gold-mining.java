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

        // 모든 좌표 (x, y)를 중심으로 탐색
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                int goldCollected = 0;
                
                // 작은 마름모에서부터 시작, 확장해 나가면서 계산
                for (int k = 0; k < n; k++) {
                    // 마름모 영역에 추가되는 부분만 계산
                    for (int i = -k; i <= k; i++) {
                        int upperY = y + (k - Math.abs(i));
                        int lowerY = y - (k - Math.abs(i));

                        // 상한 부분이 범위 내에 있다면 금 수집
                        if (x + i >= 0 && x + i < n && upperY >= 0 && upperY < n) {
                            goldCollected += grid[x + i][upperY];
                        }
                        // 하한 부분이 범위 내에 있다면 금 수집 (중복 방지)
                        if (x + i >= 0 && x + i < n && lowerY >= 0 && lowerY < n && upperY != lowerY) {
                            goldCollected += grid[x + i][lowerY];
                        }
                    }

                    // 채굴 비용 계산: k*k + (k+1)*(k+1)
                    int cost = k * k + (k + 1) * (k + 1);

                    // 수익이 비용보다 크거나 같으면 유효한 경우
                    if (goldCollected * m >= cost) {
                        maxGold = Math.max(maxGold, goldCollected);
                    } else {
                        // 손해를 보기 시작하면 더 이상 큰 마름모는 시도할 필요 없음
                        break;
                    }
                }
            }
        }

        // 결과 출력
        System.out.println(maxGold);
    }
}