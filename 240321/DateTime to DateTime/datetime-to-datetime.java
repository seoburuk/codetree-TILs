import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int day = sc.nextInt();
        int hour = sc.nextInt();
        int minute = sc.nextInt();

        int total = (minute - 11) + (hour - 11) * 60+ (day - 11) * 24 * 60;
        if(total < 0)
            total = -1;
        System.out.print(total);
        
    }
}