import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[][] x = new int[n][2];
        
        for(int i = 0; i < n; i++) {
            x[i][0] = sc.nextInt();
            x[i][1] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {
            int currentStart = 0;
            int currentEnd = 100;
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                currentStart = Math.max(x[j][0], currentStart);
                currentEnd = Math.min(x[j][1], currentEnd);

                if(currentEnd >= currentStart) {
                    System.out.print("Yes");
                    return;
                }
            }
        }
        System.out.print("No");
    }
}