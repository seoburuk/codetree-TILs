import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력 처리
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] stones = new int[n];
        
        for (int i = 0; i < n; i++) {
            stones[i] = sc.nextInt();
        }
        sc.close();
        
        // DP 배열 초기화
        int[] dp = new int[n];
        
        // 첫 돌의 값은 시작점이므로 그 자체가 최댓값
        dp[0] = stones[0];
        
        // DP로 최댓값의 최소화 계산
        for (int i = 1; i < n; i++) {
            int minMaxValue = Integer.MAX_VALUE;
            for (int j = Math.max(0, i - k); j < i; j++) {
                minMaxValue = Math.min(minMaxValue, Math.max(dp[j], stones[i]));
            }
            dp[i] = minMaxValue;
        }
        
        // 결과 출력
        System.out.println(dp[n - 1]);
    }
}