import java.lang.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ss = br.readLine();

        String[] s = ss.split(" ");
        int n = Integer.valueOf(s[0]);
        int m = Integer.valueOf(s[1]);
        int[][] board = new int[n+1][n+1];

        // 하, 좌, 상, 우
        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};

        for(int i=0; i<m; i++) {

            String st = br.readLine();
            String[] str  = st.split(" ");

            int x = Integer.valueOf(str[0]);
            int y = Integer.valueOf(str[1]);
            
            board[x][y] = 1;

            int cnt = 0;
            // 방향 체크
            for(int p=0; p<4; p++) {

                int nx = x+dx[p];
                int ny = y+dy[p];

                if( 0<nx && nx<=n && 0<ny && ny<=n && board[nx][ny]==1 ) {
                    ++cnt;
                }
            }
            if(cnt == 3) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }

        }

    }
}