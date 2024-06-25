import java.util.Scanner;

public class Main {
    public static final int WORD_LENGTH = 3;
    public static final String TARGET_WORD = "LEE";

    public static int[] dx = {1, 0, -1, 1, -1, 1, 0, -1}; // directions: right, down, left, up-right, up-left, down-right, down-left, up
    public static int[] dy = {0, 1, 1, 1, 1, -1, -1, -1};

    public static boolean inRange(int x, int y, int n, int m) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    public static boolean checkWord(char[][] board, int x, int y, int direction, int n, int m) {
        for (int i = 0; i < WORD_LENGTH; i++) {
            int nx = x + i * dx[direction];
            int ny = y + i * dy[direction];
            if (!inRange(nx, ny, n, m) || board[nx][ny] != TARGET_WORD.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine(); // consume newline
        char[][] board = new char[n][m];

        // Read the board
        for (int i = 0; i < n; i++) {
            board[i] = sc.nextLine().toCharArray();
        }

        int countLEE = 0;

        // Check for 'LEE' pattern
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'L') {
                    for (int k = 0; k < 8; k++) {
                        if (checkWord(board, i, j, k, n, m)) {
                            countLEE++;
                        }
                    }
                }
            }
        }

        System.out.println(countLEE);
    }
}