import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int top[] = new int[n];
        int bottom[] = new int[n];

        for(int i = 0; i < n; i++) {
            top[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {
            bottom[i] = sc.nextInt();
        }   

        for(int time = 0; time < t; time++) {
            int bottomLast = bottom[n-1];
            for(int i = n-1; i > 0; i--) {
                bottom[i] = bottom[i-1];
            }
            bottom[0] = top[n-1];
            for(int i = n-1; i > 0; i--) {
                top[i] = top[i-1];
            }
            top[0] = bottomLast;

        }
        for (int i = 0; i < n; i++) {
            System.out.print(top[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(bottom[i] + " ");
        }
    }
}