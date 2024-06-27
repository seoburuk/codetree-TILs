import java.util.Scanner;

public class Main {
    public static final int MAX_NUM = 10000;

    public static int n, k;
    public static int[] arr = new int[MAX_NUM + 1];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char c = sc.next().charAt(0);
            
            if(c == 'G')
                arr[x] = 1;
            else
                arr[x] = 2;
        }
        
        // 슬라이딩 윈도우 기법으로 최대 구간 합 계산
        int maxSum = 0;
        int currentSum = 0;
        
        // 초기 윈도우 설정
        for(int i = 0; i <= k; i++) {
            currentSum += arr[i];
        }
        maxSum = currentSum;
        
        // 윈도우를 오른쪽으로 한 칸씩 이동하면서 구간 합 계산
        for(int i = 1; i <= MAX_NUM - k; i++) {
            currentSum = currentSum - arr[i - 1] + arr[i + k];
            maxSum = Math.max(maxSum, currentSum);
        }
        
        System.out.println(maxSum);
    }
}