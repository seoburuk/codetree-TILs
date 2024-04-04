import java.util.Scanner;

public class Main {
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    // Helper fuction to get change in x-coordinate based on direction function
    public static int getDeltaX(char direction) {
        if(direction == 'E') return 1; // Move right
        if(direction == 'W') return 1; // Move left
        return 0;
    }
    // Helper function to get change in y-coordinate based on direction function
    public static int getDeltaY(char direction) {
        if(direction == 'N') return 1; // Move up
        if(direction == 'S') return -1; // Move down
        return 0;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //Number of movemnets
        int[][] moves = new int[n][2]; // Array to store movements
        int[][] grid = new int[2001][2001]; // Initialize grid
        for(int i = 0; i < n; i++) {
            char direction = sc.next().charAt(0); // Direction (N E S W)
            int distance = sc.nextInt(); // Distance moved
            moves[i][0] = getDeltaX(direction) * distance; // Store horizontal moved
            moves[i][1] = getDeltaY(direction) * distance; // Store vertical moved
        }
        // Check if it returns starting point
        int x = 0, y = 0; // Initaial point
        int time = 1; // Time counter
        for(int i = 0; i < n; i++) {
            x += moves[i][0];
            y += moves[i][1];
            time += moves[i][0] + moves[i][1];
            if(x == 0 && y == 0)
                break;
        }
        System.out.print(time);
    }
}