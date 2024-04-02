import java.lang.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        int n = Integer.parseInt(line);
        int[][] board = new int[n+1][n+1];
        for(int i=0; i<n; i++) {
            String read = br.readLine();
            String[] num = read.split(" ");
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(num[j]);
            }
        }

        int result = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {

                int cnt = 0;
                // 방향
                for(int k=0; k<4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if((nx>=0 && nx<n && ny>=0 && ny<n) && board[nx][ny]==1) {
                        ++cnt;
                    }
                }
                // 방향 카운트
                if(cnt >= 3) {
                    ++result;
                }
            }
        }

        System.out.println(result);
    }
}