import java.util.Scanner;

public class Main {
    public static final int arr[] = new int[2001];
    public static final int offset = 1000;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt() + offset;
        }
        
        int ans = 0, cnt = 0;
        
        for (int i = 0; i < n; i++) {
            if (i > 0 && ((arr[i] > 1000 && arr[i - 1] > 1000) || (arr[i] < 1000 && arr[i - 1] < 1000))) {
                cnt++;
            } else {
                cnt = 1;
            }
            ans = Math.max(ans, cnt);
        }
        
        System.out.println(ans);
    }
}