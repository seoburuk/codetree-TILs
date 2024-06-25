import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[19][19];

        // Read the board
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        // Directions: right, down, down-right, down-left
        int[][] directions = {
            {0, 1},
            {1, 0},
            {1, 1},
            {1, -1}
        };

        // Checking for a win condition
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] != 0) {
                    int currentColor = board[i][j];
                    for (int[] direction : directions) {
                        if (isWinningSequence(board, i, j, direction, currentColor)) {
                            System.out.println(currentColor);
                            int midRow = i + 2 * direction[0] + 1;
                            int midCol = j + 2 * direction[1] + 1;
                            System.out.println(midRow + " " + midCol);
                            return; // Exit once we find a winner
                        }
                    }
                }
            }
        }

        // No winner
        System.out.println("0");
    }

    public static boolean isWinningSequence(int[][] board, int row, int col, int[] direction, int color) {
        for (int k = 0; k < 5; k++) {
            int newRow = row + k * direction[0];
            int newCol = col + k * direction[1];
            if (newRow < 0 || newRow >= 19 || newCol < 0 || newCol >= 19 || board[newRow][newCol] != color) {
                return false;
            }
        }
        // Check for the sixth stone in the same direction to ensure only exactly five stones
        int sixthRow = row + 5 * direction[0];
        int sixthCol = col + 5 * direction[1];
        if (sixthRow >= 0 && sixthRow < 19 && sixthCol >= 0 && sixthCol < 19 && board[sixthRow][sixthCol] == color) {
            return false;
        }
        // Check for the preceding stone to ensure only exactly five stones
        int precedingRow = row - direction[0];
        int precedingCol = col - direction[1];
        if (precedingRow >= 0 && precedingRow < 19 && precedingCol >= 0 && precedingCol < 19 && board[precedingRow][precedingCol] == color) {
            return false;
        }
        return true;
    }
}