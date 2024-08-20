import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] hills = new int[n];
        for(int i = 0; i < n; i++) {
            hills[i] = sc.nextInt();
        }
        int minValue = Integer.MAX_VALUE;
        for(int low = 0; low < 87; low++) {
            int high = low+17;
            int currentCost = 0;
            for(int i = 0; i<n; i++) {
                if(low > hills[i]) {
                currentCost += (low - hills[i])*(low - hills[i]);
            }
            if(high < hills[i]) {
                currentCost += (hills[i] - high) * (hills[i] - high);
            }
            }
            minValue = Math.min(currentCost, minValue);
        }
        System.out.print(minValue);
    }
}