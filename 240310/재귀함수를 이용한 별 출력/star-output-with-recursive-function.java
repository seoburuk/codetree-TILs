import java.util.Scanner;

public class Main {
    public static void printStars(int n, int current) {
        if (current > n) {
            return; // 재귀 종료 조건: 현재 줄이 입력된 수를 넘어가면 종료
        }
        // 현재 줄 번호(current)만큼의 별 출력
        for (int i = 0; i < current; i++) {
            System.out.print("*");
        }
        System.out.println(); // 줄 바꿈

        // 다음 줄을 출력하기 위해 재귀 호출
        printStars(n, current + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 재귀 함수 호출
        printStars(n, 1);
    }
}