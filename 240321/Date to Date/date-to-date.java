import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        //Caculate total days from starting date to ending date
        int totalDays= d2 - d1 +1;
        //Array to store days in each month
        int[] daysOfMonths = {31, 28 ,31 ,30, 31, 30, 31, 31, 30 ,31, 30 ,31};
        //Add days from next month after starting month to month before ending month
        for(int i = m1; i < m2; i++) {
            totalDays += daysOfMonths[i - 1];
        }
        //output
        System.out.print(totalDays);
    }
}