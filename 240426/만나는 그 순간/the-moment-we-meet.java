import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] a_go = new int[1000]; // 충분한 크기의 배열로 설정
        int[] b_go = new int[1000]; // 충분한 크기의 배열로 설정
        
        int cnt_a = 0;
        for(int i = 0; i < n; i++) {
            int dir = sc.next().equals("L") ? -1 : 1;
            int path = sc.nextInt();

            for(int j = 0; j < path; j++) {
                a_go[cnt_a+1] = a_go[cnt_a] + 1 * dir;  
                cnt_a += 1;
            }              
        }

        int cnt_b = 0;
        for(int i = 0; i < m; i++) {
            int dir = sc.next().equals("L") ? -1 : 1;
            int path = sc.nextInt();

            for(int j = 0; j < path; j++) {
                b_go[cnt_b+1] = b_go[cnt_b] + 1 * dir;  
                cnt_b += 1;
            }              
        }

        int ans = 0;
        for(int i = 1; i < Math.max(cnt_a, cnt_b); i++) {
            if(a_go[i] == b_go[i]) {
                ans = i;
                break;
            }
        }

        System.out.println(ans == 0 ? -1 : ans);

    }
}