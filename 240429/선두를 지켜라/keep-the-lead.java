import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // A의 이동 횟수
        int m = sc.nextInt(); // B의 이동 횟수
        
        int[] arrA = new int[n * 1000]; // A의 이동 경로 배열
        int[] arrB = new int[m * 1000]; // B의 이동 경로 배열
        
        int totalTimeA = 0; // A의 총 이동 시간
        int totalTimeB = 0; // B의 총 이동 시간
        
        // A의 이동 입력 및 이동 경로 기록
        for(int i = 0; i < n; i++) {
            int v = sc.nextInt(); // 속도
            int t = sc.nextInt(); // 시간
            for(int j = 0; j < t; j++) {
                arrA[totalTimeA++] = v; // 이동 경로 기록
            }
        }
        
        // B의 이동 입력 및 이동 경로 기록
        for(int i = 0; i < m; i++) {
            int v = sc.nextInt(); // 속도
            int t = sc.nextInt(); // 시간
            for(int j = 0; j < t; j++) {
                arrB[totalTimeB++] = v; // 이동 경로 기록
            }
        }
        
        // 선두가 바뀌는 횟수 계산
        int change = 0; // 선두가 바뀌는 횟수
        int prevDiff = 0; // 이전 A와 B의 위치 차이
        int currDiff = 0; // 현재 A와 B의 위치 차이
        
        for(int i = 0; i < Math.min(totalTimeA, totalTimeB); i++) {
            currDiff = arrA[i] - arrB[i]; // 현재 A와 B의 위치 차이 계산
            
            if(prevDiff * currDiff < 0) { // 이전 위치 차이와 현재 위치 차이가 부호가 다르면
                change++; // 선두가 바뀜
            }
            
            prevDiff = currDiff; // 이전 위치 차이 업데이트
        }
        
        System.out.println(change); // 선두가 바뀐 횟수 출력
    }
}