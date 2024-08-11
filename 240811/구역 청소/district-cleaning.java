import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc= new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        if(b < c || a < d) {
            int x, y = 0;
        x = Math.min(a, c);
        y = Math.max(b, d);
        System.out.print(y-x);
        } else {
            System.out.print(b-a+d-c);
        }
        
    }
}