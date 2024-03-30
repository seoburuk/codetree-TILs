import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int maxLength = 1;
        int current = 1;

        for(int i = 1; i < n; i++) {
            if(a[i] > a[i - 1]) {
                current++;
            } else {
                maxLength = Math.max(current, maxLength);
                current = 1;
            }

            
        }
        System.out.print(maxLength);
    }
}