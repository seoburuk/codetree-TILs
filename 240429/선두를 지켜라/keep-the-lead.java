import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // A의 이동 횟수
        int m = sc.nextInt(); // B의 이동 횟수
        
        int[] va = new int[n]; // A의 속도 배열
        int[] vb = new int[m]; // B의 속도 배열
        
        // A의 속도 입력
        for (int i = 0; i < n; i++) {
            va[i] = sc.nextInt();
            int t = sc.nextInt(); // A의 이동 시간은 입력으로 받지만 사용하지 않음
        }
        
        // B의 속도 입력
        for (int i = 0; i < m; i++) {
            vb[i] = sc.nextInt();
            int t = sc.nextInt(); // B의 이동 시간은 입력으로 받지만 사용하지 않음
        }
        
        int change = 0; // 선두가 바뀐 횟수
        int prevDiff = 0; // 이전 A와 B의 위치 차이
        
        // A와 B의 위치를 계산하며 선두가 바뀌는지 확인
        for (int i = 0; i < Math.max(n, m); i++) {
            int aPos = i < n ? va[i] : 0; // A의 위치 계산
            int bPos = i < m ? vb[i] : 0; // B의 위치 계산
            
            int diff = aPos - bPos; // A와 B의 위치 차이
            
            if (diff != 0 && prevDiff >= 0 && diff < 0) {
                change++; // 선두가 바뀌는 경우 선두 변경 횟수 증가
            }
            
            prevDiff = diff; // 이전 위치 차이 업데이트
        }
        
        System.out.println(change); // 선두 변경 횟수 출력
    }
}