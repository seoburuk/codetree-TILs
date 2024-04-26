import java.util.Scanner;

public class Main {

    private static int max = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n명의 학생
        int m = sc.nextInt(); // m번 벌칙
        int k = sc.nextInt(); // k번 이상 벌칙이면 벌금

        int[] penalties = new int[n + 1]; // 각 학생이 받은 벌칙 횟수를 저장하는 배열

        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            penalties[num]++; // 해당 학생이 벌칙을 받음
            if (penalties[num] == k) { // 해당 학생이 k번 벌칙을 받았다면
                System.out.println(num); // 학생의 번호 출력
                return;
            }
        }
        // 벌칙을 k번 이상 받은 학생이 없는 경우
        System.out.println(-1);
    }
}