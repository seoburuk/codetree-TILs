import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int pigeonPosition[] = new int[11];
        // first positions dont know
        for(int i = 1; i <= 10; i++) {
            pigeonPosition[i] = -1;
        }
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            int pigeon = sc.nextInt();
            int position = sc.nextInt();

            if(pigeonPosition[pigeon] == -1) {
                pigeonPosition[pigeon] = position;
            } else if (pigeonPosition[pigeon] != position) {
                cnt++;
                pigeonPosition[pigeon] = position;
            }
        }
        System.out.print(cnt);
    }
}