import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr); // 배열을 정렬

        if (k >= 1 && k <= n) { // k가 유효한 범위인지 확인
            System.out.println(arr[k - 1]); // k번째 원소 출력
        } else {
            System.out.println("Invalid value of k"); // k가 유효하지 않은 경우 오류 메시지 출력
        }
    }
}