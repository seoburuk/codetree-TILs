import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour1 = sc.nextInt();
        int min1 = sc.nextInt();
        int hour2 = sc.nextInt();
        int min2 = sc.nextInt();
        // 여기에 코드를 작성해주세요.
        int elaspedTime = 0;

        while(true) {
            if(hour1 == hour2 && min1 == min2)
                break;
            
            elaspedTime++;
            min1++;

            if(min1 == 60) {
                min1 = 0;
                hour1++;
            }
            
        }

        System.out.print(elaspedTime);
    }
}