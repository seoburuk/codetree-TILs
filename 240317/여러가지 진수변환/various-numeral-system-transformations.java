import java.util.Scanner;

public class Main {
    public static String change(int n, int b) {
        StirngBuilder result = new StirngBuilder();
        while(n > 0) {
            int remainder = n % b;
            result.insert(remainder, 0);
            n/b;
        }
        
        return result.toString;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();

        System.out(change(int n, int b));
    }
}