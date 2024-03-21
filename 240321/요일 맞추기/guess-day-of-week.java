import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        // Array to store days in each month
        int[] daysOfMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Calculate total days from starting date to ending date
        int total = d2 - d1 + 1;
        for (int i = m1; i < m2; i++) {
            total += daysOfMonths[i - 1];
        }

        // Calculate the day of the week
        int remainder = total % 7;
        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        String day = remainder < 0 ? daysOfWeek[7 + remainder] : daysOfWeek[remainder];

        // Output
        System.out.println(day);
    }
}