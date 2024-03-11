import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int arr2[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        Arrays.sort(arr2);

        String result = Arrays.eqaul(arr, arr2) ? "Yes": "No";
        System.out.print(result);

    }
}