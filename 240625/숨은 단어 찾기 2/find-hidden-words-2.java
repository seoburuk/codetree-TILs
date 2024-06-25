import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        char[][] board = new char[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = sc.nextLine().toCharArray();
        }

        int countLEE = 0;

        // Define the 8 possible directions (right, down, diagonal down-right, diagonal down-left, left, up, diagonal up-right, diagonal up-left)
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {1, 0, 1, -1, -1, 0, 1, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'L') {
                    for (int d = 0; d < 8; d++) {
                        if (checkWord(board, i, j, dx[d], dy[d], n, m)) {
                            countLEE++;
                        }
                    }
                }
            }
        }

        System.out.println(countLEE);
    }

    public static boolean checkWord(char[][] board, int x, int y, int dx, int dy, int n, int m) {
        String word = "LEE";
        for (int k = 0; k < word.length(); k++) {
            int nx = x + dx * k;
            int ny = y + dy * k;
            if (nx < 0 || ny < 0 || nx >= n || ny >= m || board[nx][ny] != word.charAt(k)) {
                return false;
            }
        }
        return true;
    }
}