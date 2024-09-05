import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] belt1 = new int[n];
        int[] belt2 = new int[n];
        int[] belt3 = new int[n];

        for(int i = 0; i < n; i++) {
            belt1[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {
            belt2[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {
            belt3[i] = sc.nextInt();
        }

        for(int time = 0; time < t; time++) {
            int belt3Last = belt3[n-1];
            for(int i = n-1; i > 0; i--) {
                belt3[i] = belt3[i-1];
            }
            belt3[0] = belt2[n-1];
            for(int i = n-1; i > 0; i--) {
                belt2[i] = belt2[i-1];
            }
            belt2[0] = belt1[n-1];
            for(int i = n-1; i > 0; i--) {
                belt1[i] = belt1[i-1];
            }
            belt1[0] = belt3Last;
        }

        for(int i = 0; i < n; i++) {
            System.out.print(belt1[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < n; i++) {
            System.out.print(belt2[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < n; i++) {
            System.out.print(belt3[i] + " ");
        }
        System.out.println();
    }
}