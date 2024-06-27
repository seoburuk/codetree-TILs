import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();    
        int m = sc.nextInt();
        int num1[] = new int[n];
        int num2[] = new int[m];
        
        // 수열 A 입력
        for(int i = 0; i < n; i++) {
            num1[i] = sc.nextInt();
        }
        
        // 수열 B 입력
        for(int i = 0; i < m; i++) {
            num2[i] = sc.nextInt();
        }

        // 아름다운 수열 개수를 세기 위한 변수
        int cnt = 0;
        
        // 수열 B 정렬
        Arrays.sort(num2);
        
        // 수열 A에서 길이가 M인 모든 연속 부분 수열 탐색
        for(int i = 0; i <= n - m; i++) {
            // 부분 수열 추출
            int[] subArray = Arrays.copyOfRange(num1, i, i + m);
            
            // 부분 수열 정렬
            Arrays.sort(subArray);

            // 정렬된 부분 수열과 수열 B 비교
            if(Arrays.equals(subArray, num2)) {
                cnt++;
            }
        }

        // 결과 출력
        System.out.print(cnt);
    }
}