import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] a_go = new int[2001]; // 인덱스 0을 사용하지 않고 1부터 시작
        int[] b_go = new int[2001]; // 인덱스 0을 사용하지 않고 1부터 시작
        
        int cnt_a = 0;
        for(int i = 0; i < n; i++) {
            char dir = sc.next().charAt(0); // 문자열을 char로 변경
            int path = sc.nextInt();

            for(int j = 0; j < path; j++) {
                if (dir == 'L') {
                    a_go[++cnt_a] = a_go[cnt_a - 1] - 1; // 왼쪽으로 이동
                } else {
                    a_go[++cnt_a] = a_go[cnt_a - 1] + 1; // 오른쪽으로 이동
                }
            }              
        }

        int cnt_b = 0;
        for(int i = 0; i < m; i++) {
            char dir = sc.next().charAt(0); // 문자열을 char로 변경
            int path = sc.nextInt();

            for(int j = 0; j < path; j++) {
                if (dir == 'L') {
                    b_go[++cnt_b] = b_go[cnt_b - 1] - 1; // 왼쪽으로 이동
                } else {
                    b_go[++cnt_b] = b_go[cnt_b - 1] + 1; // 오른쪽으로 이동
                }
            }              
        }

        int ans = 0;
        for(int i = 1; i <= Math.max(cnt_a, cnt_b); i++) { // 등호 추가
            if(a_go[i] == b_go[i]) {
                ans = i;
                break;
            }
        }

        System.out.println(ans == 0 ? -1 : ans);

    }
}