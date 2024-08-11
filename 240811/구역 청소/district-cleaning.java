import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); // Start of interval A
        int b = sc.nextInt(); // End of interval A
        int c = sc.nextInt(); // Start of interval B
        int d = sc.nextInt(); // End of interval B

        // Calculate the cleaned area
        if (b < c || d < a) {
            // No overlap
            int totalCleanedLength = (b - a) + (d - c);
            System.out.println(totalCleanedLength);
        } else {
            // Overlap exists
            int start = Math.min(a, c);
            int end = Math.max(b, d);
            int totalCleanedLength = end - start;
            System.out.println(totalCleanedLength);
        }
        
        sc.close();
    }
}