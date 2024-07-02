import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력 처리
        int n = sc.nextInt();
        int h = sc.nextInt();
        int t = sc.nextInt(); // 최소 연속 구간 길이
        
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }
        
        int minCost = Integer.MAX_VALUE;
        
        // 모든 시작점 i와 끝점 j를 잡아봅니다.
        for (int i = 0; i <= n - t; i++) {
            for (int j = i + t - 1; j < n; j++) {
                // 구간 내에서 높이를 H로 맞추기 위한 비용을 계산합니다.
                int cost = 0;
                for (int k = i; k <= j; k++) {
                    cost += Math.abs(height[k] - h);
                }
                // 최소 비용을 갱신합니다.
                minCost = Math.min(minCost, cost);
            }
        }
        
        // 결과 출력
        System.out.println(minCost);
    }
}