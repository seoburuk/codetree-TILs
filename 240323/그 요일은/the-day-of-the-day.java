import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] MONTHS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] WEEKEND = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        int m1, d1, m2, d2;
        String week;
        
        m1 = sc.nextInt();
        d1 = sc.nextInt();
        m2 = sc.nextInt();
        d2 = sc.nextInt();
        sc.nextLine(); // Consume newline
        week = sc.nextLine();

        int days;
        if (m1 != m2) {
            days = MONTHS[m1] - d1 + 1;
            for (int i = m1 + 1; i < m2; i++) {
                days += MONTHS[i];
            }
            days += d2;
        } else {
            days = d2 - d1 + 1;
        }

        int index = -1;
        for (int i = 0; i < WEEKEND.length; i++) {
            if (WEEKEND[i].equals(week)) {
                index = i;
                break;
            }
        }

        if (index + 1 <= (days % 7) && days > 7) {
            System.out.println(days / 7 + 1);
        } else if (days < 7) {
            if (index + 1 <= (days % 7)) {
                System.out.println(1);
            }
        } else {
            System.out.println(days / 7);
        }
    }
}