import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // 로봇 A의 움직임 횟수
        int m = sc.nextInt(); // 로봇 B의 움직임 횟수
        
        int[] movesA = new int[50000]; // 로봇 A의 움직임 배열
        int[] movesB = new int[50000]; // 로봇 B의 움직임 배열
        
        // 로봇 A의 움직임 입력
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt(); // 움직인 시간
            char d = sc.next().charAt(0); // 방향 ('L' 또는 'R')
            movesA[i] = t * (d == 'L' ? -1 : 1); // 왼쪽으로 움직이면 음수, 오른쪽으로 움직이면 양수로 저장
        }
        
        // 로봇 B의 움직임 입력
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt(); // 움직인 시간
            char d = sc.next().charAt(0); // 방향 ('L' 또는 'R')
            movesB[i] = t * (d == 'L' ? -1 : 1); // 왼쪽으로 움직이면 음수, 오른쪽으로 움직이면 양수로 저장
        }
        
        // 로봇 A와 B가 서로 마주치는 경우를 계산
        int count = 0;
        int prevPosA = 0;
        int prevPosB = 0;
        
        for (int i = 0; i < Math.max(n, m); i++) {
            int posA = prevPosA + (i < n ? movesA[i] : 0); // 로봇 A의 현재 위치 계산
            int posB = prevPosB + (i < m ? movesB[i] : 0); // 로봇 B의 현재 위치 계산
            
            if ((prevPosA < prevPosB && posA >= posB) || (prevPosA > prevPosB && posA <= posB)) {
                count++; // 서로 마주치는 경우 카운트 증가
            }
            
            prevPosA = posA;
            prevPosB = posB;
        }
        
        System.out.println(count);
    }
}