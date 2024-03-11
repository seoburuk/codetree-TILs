import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = nextInt();
        String words[] = new String[n];

        for(int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        Arrays.sort(words);

        for(int i = 0; i < n; i++) {
            System.out.println(words[i]);
        }
        // 여기에 코드를 작성해주세요.
    }
}