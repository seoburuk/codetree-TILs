import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int totalTime = 0;
        int change = 0;
        int prevDiff = 0;

        for(int i = 0; i < n; i++){
            int v = sc.nextInt();
            int t = sc.nextInt();
            int cnt = v * t;
            totalTime += t;
            int currDiff = cnt - prevDiff;
            if (currDiff * prevDiff < 0) {
                change++;
            }
            prevDiff = cnt;
        }

        prevDiff = 0;
        for(int i = 0; i < m; i++){
            int v = sc.nextInt();
            int t = sc.nextInt();
            int cnt = v * t;
            totalTime += t;
            int currDiff = cnt - prevDiff;
            if (currDiff * prevDiff < 0) {
                change++;
            }
            prevDiff = cnt;
        }

        System.out.print(change);
    }
}