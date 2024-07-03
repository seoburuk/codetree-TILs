import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        int a3 = sc.nextInt();
        int b1 = sc.nextInt();
        int b2 = sc.nextInt();
        int b3 = sc.nextInt();

        int sum = 250;
        int dif = Math.abs(a1 - b1) -11 + Math.abs(a2 - b2) + Math.abs(a3 - b3);
        System.out.print(sum - dif);
    }
}