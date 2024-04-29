import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // A의 이동 횟수
        int m = sc.nextInt(); // B의 이동 횟수
        
        int[] arrA = new int[n * 1000]; // A의 이동 경로 배열
        int[] arrB = new int[m * 1000]; // B의 이동 경로 배열
        
        int totalTime = 0; // A의 총 이동 시간
        int cnt = 0;
        
        // A의 이동 입력 및 이동 경로 기록
        for(int i = 0; i < n; i++) {
            int v = sc.nextInt(); // 속도
            int t = sc.nextInt(); // 시간
            for(int j = 0; j < t; j++) {
                cnt+=v;
                arrA[totalTime++] = cnt; // 이동 경로 기록
            }
        }
        totalTime = 0;
        cnt = 0;
        // B의 이동 입력 및 이동 경로 기록
        for(int i = 0; i < m; i++) {
            int v = sc.nextInt(); // 속도
            int t = sc.nextInt(); // 시간
            for(int j = 0; j < t; j++) {
                cnt += v;
                arrB[totalTime++] = cnt; // 이동 경로 기록
            }
        }
        Integer change = 0;
        Integer curr = 0;
        Integer[] diff = new Integer[totalTime];
        for(int i = 0; i < totalTime; i++){
            diff[i] = (arrA[i] - arrB[i]);
            if(diff[i] < 0) {
                if(-1 * curr < 0){
                    change++;
                }
            } else if(diff[i] > 0) {
                if(-1 * curr > 0) {
                    change++;
                }
            }
            if(diff[i] != 0) {
                curr = diff[i];
            }
        }
        
     
        System.out.println(change); // 선두가 바뀐 횟수 출력
    }
}