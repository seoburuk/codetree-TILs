import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 격자의 크기
        int m = sc.nextInt(); // 색칠할 칸의 개수
        int[][] grid = new int[n][n]; // 격자 초기화

        // 색칠할 칸의 위치를 입력 받아서 격자에 색칠합니다.
        for (int i = 0; i < m; i++) {
            int r = sc.nextInt() - 1; // 행
            int c = sc.nextInt() - 1; // 열
            grid[r][c] = 1; // 색칠
            // 색칠 후 편안한 상태인지 확인하여 출력합니다.
            if (isComfortable(grid, r, c, n)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }

    // 주어진 격자와 색칠된 칸의 위치를 이용하여 해당 칸이 편안한 상태인지를 확인하는 메소드
    public static boolean isComfortable(int[][] grid, int x, int y, int n) {
        int[] dx = {0, 1, 0, -1}; // x 좌표 이동
        int[] dy = {1, 0, -1, 0}; // y 좌표 이동
        int cnt = 0; // 주변에 색칠된 칸의 개수
        for (int i = 0; i < 4; i++) {
            int curX = x + dx[i]; // 주변 칸의 x 좌표
            int curY = y + dy[i]; // 주변 칸의 y 좌표
            // 격자를 벗어나지 않고, 주변 칸이 색칠된 상태라면 개수를 증가시킵니다.
            if (curX >= 0 && curX < n && curY >= 0 && curY < n && grid[curX][curY] == 1) {
                cnt++;
            }
        }
        // 주변에 색칠된 칸이 3개 이상이면 편안한 상태입니다.
        return cnt >= 3;
    }
}