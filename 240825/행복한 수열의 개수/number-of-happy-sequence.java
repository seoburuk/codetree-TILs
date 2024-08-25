import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // n과 m 입력받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        // n * n 크기의 격자 입력받기
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int happySequence = 0;

        // 각 행에서 행복한 수열 검사
        for (int i = 0; i < n; i++) {
            if (isHappySequence(grid[i], m)) {
                happySequence++;
            }
        }

        // 각 열에서 행복한 수열 검사
        for (int j = 0; j < n; j++) {
            int[] column = new int[n];
            for (int i = 0; i < n; i++) {
                column[i] = grid[i][j];
            }
            if (isHappySequence(column, m)) {
                happySequence++;
            }
        }

        // 결과 출력
        System.out.println(happySequence);
    }

    // 연속한 숫자가 m개 이상 있는지 확인하는 함수
    public static boolean isHappySequence(int[] sequence, int m) {
        int cnt = 1;

        for (int i = 1; i < sequence.length; i++) {
            if (sequence[i] == sequence[i - 1]) {
                cnt++;
                if (cnt >= m) {
                    return true;
                }
            } else {
                cnt = 1; // 연속이 끊기면 초기화
            }
        }

        return false;
    }
}