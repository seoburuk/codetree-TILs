import java.util.Scanner;

public class Main {
    public static boolean isComfortable(int[][] grid, int x, int y, int n) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int curX = x + dx[i];
            int curY = y + dy[i];
            if (curX >= 0 && curX < n && curY >= 0 && curY < n && grid[curX][curY] == 1) {
                cnt++;
            }
        }
        return cnt >= 3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 격자의 크기
        int[][] grid = new int[n][n];
        int m = sc.nextInt(); // 채워넣을 칸의 개수
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            grid[x - 1][y - 1] = 1;
            if (isComfortable(grid, x - 1, y - 1, n)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}