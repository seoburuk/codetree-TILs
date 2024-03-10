import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n]; // Integer 배열로 선언하여 정렬을 위해 사용

        // 원소 입력 받기
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 오름차순 정렬 후 출력
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); // 줄 바꿈

        // 내림차순 정렬 후 출력
        Arrays.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}