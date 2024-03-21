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

        // Calculate total days from January 1st to the given date
        int totalDays = d2 - 1; // Excluding the ending date
        for (int i = 1; i < m2; i++) {
            totalDays += daysOfMonths[i - 1];
        }

        // If starting month is after ending month in the same year
        if (m1 > m2) {
            // Adjust total days to consider the starting date in the next year
            totalDays += 365; // Non-leap year
        }
        // Adjust total days to consider the starting date
        for (int i = 1; i < m1; i++) {
            totalDays -= daysOfMonths[i - 1];
        }
        totalDays -= d1 - 1; // Excluding the starting date

        // Determine the day of the week
        int dayOfWeek = totalDays % 7;

        // Adjust the day of the week according to the starting day (Monday)
        int startingDay = 1; // Monday is the first day of the week
        int adjustedDayOfWeek = (startingDay + dayOfWeek) % 7;

        // Map the day of the week to the corresponding name
        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        String day = daysOfWeek[adjustedDayOfWeek];

        // Output
        System.out.println(day);
    }
}