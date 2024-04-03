import java.lang.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splited1 = br.readLine().split(" ");
        String[] splited2 = br.readLine().split(" ");

        int n = Integer.parseInt(splited1[0]);
        int t = Integer.parseInt(splited1[1]);

        int x = Integer.parseInt(splited2[1]);
        int y = Integer.parseInt(splited2[0]);
        String d = splited2[2];

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int p = -1;

        if( "R".equals(d) ) {
            p = 0;
        } else if( "D".equals(d) ) {
            p = 1;
        } else if( "L".equals(d) ) {
            p = 2;
        } else if( "U".equals(d) ) {
            p = 3;
        } else {
            p = -1; // 또는 오류 처리
        }

        int nx = x;
        int ny = y;
        for (int i = 0; i < t; i++) {
            x += dx[p];
            y += dy[p];
            if ( 0 < x && x <= n && 0 < y && y <= n ) {
            // if(0 <= x && x < n && 0 <= y && y < n){
                nx = x;
                ny = y;
                // System.out.println("한칸이동");
            } else {
                p = (p + 2) % 4;
                x = nx;
                y = ny;
                // System.out.println("방향만 바꿈");
            }

            // System.out.println(p+" i "+i+" nx:" +nx);
            // System.out.println(p+" i "+i+" ny:" +ny);
            // System.out.println(p+" i "+i+" x:" +x);
            // System.out.println(p+" i "+i+" y:" +y);
        }

        System.out.println(y + " " + x);
    }
}