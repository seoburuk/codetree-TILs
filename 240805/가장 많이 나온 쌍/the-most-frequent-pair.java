import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<String, Integer> pairCount = new HashMap<>();
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            String pair = a < b ? a + " " + b : b + " " + a;
            pairCount.put(pair, pairCount.getOrDefault(pair, 0) + 1);
        }
        int maxCount = 0;
        for(int count : pairCount.values()) {
            maxCount = Math.max(count, maxCount);
        }
        System.out.print(maxCount);
    }
}