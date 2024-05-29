import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][n];
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0 ; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0 ; j < n-2; j++) {
                cnt = Math.max(cnt, arr[i][j] + arr[i][j+1] + arr[i][j+2]);
            }
        }
        
        System.out.println(cnt);
    }
}