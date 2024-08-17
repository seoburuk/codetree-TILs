import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int length1 = Math.abs(a-x) + Math.abs(b-y);
        int length2 = Math.abs(b-x) + Math.abs(a-y);
        System.out.print(Math.min(length1,length2));
    }
}