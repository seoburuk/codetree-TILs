import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] x = new int[n][2];
        
        for(int i = 0; i < n; i++) {
            x[i][0] = sc.nextInt();
            x[i][1] = sc.nextInt();
        }

        for(int i = 0; i < n; i++) {
            int currentStart = 0;
            int currentEnd = 100;

            // n-1개의 선분으로 겹치는 구간을 계산
            for(int j = 0; j < n; j++) {
                if(i == j) continue;  // i번째 선분을 제거
                
                currentStart = Math.max(currentStart, x[j][0]);
                currentEnd = Math.min(currentEnd, x[j][1]);
            }

            // n-1개의 선분이 겹치는 구간이 존재하는지 확인
            if(currentStart <= currentEnd) {
                System.out.print("Yes");
                return;
            }
        }
        
        System.out.print("No");
    }
}