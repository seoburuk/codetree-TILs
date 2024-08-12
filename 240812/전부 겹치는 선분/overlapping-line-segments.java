import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start = 0;
        int end = 110;
        
        for(int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            start = Math.max(start, x1);
            end = Math.min(end, x2);
        }
        if(start <= end) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
        

        
    }
}