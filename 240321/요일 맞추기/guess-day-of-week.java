import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        
        int[] daysOfMonths = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        String day = "";
        int total = d2 - d1 + 1;

        for(int i = m1; i < m2; i++) {
            total += daysOfMonths[i - 1];
        }

        total %= 7;

        if(total == 0) {
            day = "Sun";
        } else if(total < 0) {
            switch(-total) {
                case 1:
                    day = "Sat";
                    break;
                case 2:
                    day = "Fri";
                    break;
                case 3:
                    day = "Thu";
                    break;
                case 4:
                    day = "Wed";
                    break;
                case 5:
                    day = "Tue";
                    break;
                case 6:
                    day = "Mon";
                    break;
            }
        } else {
            switch(total) {
                case 1:
                    day = "Mon";
                    break;
                case 2:
                    day = "Tue";
                    break;
                case 3:
                    day = "Wed";
                    break;
                case 4:
                    day = "Thu";
                    break;
                case 5:
                    day = "Fri";
                    break;
                case 6:
                    day = "Sat";
                    break;
            }
        }
        
        System.out.println(day);
    }
}