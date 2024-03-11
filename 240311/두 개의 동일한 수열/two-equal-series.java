import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrA = new int[n];
        int[] arrB = new int[n];

        // 수열 A 입력 받기
        for (int i = 0; i < n; i++) {
            arrA[i] = sc.nextInt();
        }

        // 수열 B 입력 받기
        for (int i = 0; i < n; i++) {
            arrB[i] = sc.nextInt();
        }

        // 두 수열 정렬
        Arrays.sort(arrA);
        Arrays.sort(arrB);

        // 두 수열이 같은지 판단
        String result = Arrays.equals(arrA, arrB) ? "Yes" : "No";
        System.out.println(result);
    }
}