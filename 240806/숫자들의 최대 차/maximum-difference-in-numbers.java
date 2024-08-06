import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] elements = new int[n];
        for(int i = 0; i < n; i++) {
            elements[i] = sc.nextInt();
        }
        Arrays.sort(elements);

        int maxLength = 0;
        int left = 0;
        for(int right = 0; right < n; right++) {
            while(elements[right] - elements[left] > k) {
                left++;
            }
            maxLength = Math.max(maxLength, right - left +1);
        }
        System.out.print(maxLength);
    }
}