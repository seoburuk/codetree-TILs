import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int dir;

    // Method to determine the new direction when encountering '/' mirror
    static int decision1(int dir) {
        if (dir == 0) {
            return 1; // If current direction is up, change to right
        } else if (dir == 1) {
            return 0; // If current direction is right, change to up
        } else if (dir == 2) {
            return 3; // If current direction is down, change to left
        } else {
            return 2; // If current direction is left, change to down
        }
    }

    // Method to determine the new direction when encountering '\' mirror
    static int decision2(int dir) {
        if (dir == 0) {
            return 3; // If current direction is up, change to left
        } else if (dir == 1) {
            return 2; // If current direction is right, change to down
        } else if (dir == 2) {
            return 1; // If current direction is down, change to right
        } else {
            return 0; // If current direction is left, change to up
        }
    }

    // Method to check if the current position is within the grid
    static boolean Check(int i, int j, int n) {
        return 0 <= i && i < n && 0 <= j && j < n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[][] arr = new char[n][n];

        // Read the grid configuration
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < n; j++) {
                char b;
                if (str.charAt(j) == '/')
                    b = '/';
                else
                    b = '\\';
                arr[i][j] = b;
            }
        }

        int k = Integer.parseInt(br.readLine());
        int i;
        int j;
        // Determine the starting position and direction based on k
        if (1 <= k && k <= n) {
            dir = 0;
            i = 0;
            j = k - 1;
        } else if (n + 1 <= k && k <= 2 * n) {
            dir = 1;
            i = k - n - 1;
            j = n - 1;
        } else if (2 * n + 1 <= k && k <= 3 * n) {
            dir = 2;
            i = n - 1;
            j = 3 * n - k;
        } else {
            dir = 3;
            i = 4 * n - k;
            j = 0;
        }
        // Define the dx and dy arrays for moving in different directions
        int[] dx = new int[] {1, 0, -1, 0};
        int[] dy = new int[] {0, -1, 0, 1};
        int cnt = 0;

        // Simulate the laser beam
        while (true) {
            if (arr[i][j] == '/') {
                dir = decision1(dir);
                cnt++;
            } else {
                dir = decision2(dir);
                cnt++;
            }
            i += dx[dir];
            j += dy[dir];

            boolean check = Check(i, j, n);

            if (!check)
                break;
        }
        System.out.print(cnt);
    }
}