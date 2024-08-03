import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] ranges = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            ranges[i][0] = sc.nextInt();
            ranges[i][1] = sc.nextInt();
        }
        sc.close();
        
        int result = findMin(n, ranges);
        System.out.println(result);
    }
    
    public static int findMin(int n, int[][] ranges) {
        int minValue = 0;
        for(int i = 0; i < 10000; i++) {
            if(isValid(i, n, ranges)) {
                minValue = i;
                break;
            }

        }
        
        return minValue;
    }
    
    public static boolean isValid(int x, int n, int[][] ranges) {
        for (int i = 0; i < n; i++) {
            int value = x;
            for (int j = 0; j <= i; j++) {
                value *= 2;
            }
            if (value < ranges[i][0] || value > ranges[i][1]) {
                return false;
            }
        }
        return true;
    }
}