import java.util.Scanner;

public class Main {
    public static int a[][] = new int[100][100];

    public static boolean inRange(int x, int y, int n, int m) {
        return (0 <= x && x < n && 0 <= y && y < m);
    }

    public static void main(String[] args) {
        int dx[] = {0, 1, 0, -1}; // North, East, South, West
        int dy[] = {1, 0, -1, 0};

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Declare and initialize 'n' here
        int m = sc.nextInt();

        int x = 0, y = 0;
        int dirNum = 0; // Start moving to the right (East)
        int i = 1;

        while (i <= n * m) {
            a[x][y] = i;
            int nx = x + dx[dirNum], ny = y + dy[dirNum];
            if (!inRange(nx, ny, n, m) || a[nx][ny] != 0) {
                dirNum = (dirNum + 1) % 4; // Change direction
                nx = x + dx[dirNum];
                ny = y + dy[dirNum];
            }
            x = nx;
            y = ny;
            i++;
        }

        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++)
                System.out.print(a[j][k] + " ");
            System.out.println();
        }
    }
}