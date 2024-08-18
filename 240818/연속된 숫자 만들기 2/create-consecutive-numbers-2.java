import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 세 사람의 위치 입력 받기
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        // 세 사람의 위치 정렬
        int[] positions = {a, b, c};
        Arrays.sort(positions);

        // 정렬된 위치
        a = positions[0];
        b = positions[1];
        c = positions[2];

        // 최소 이동 횟수 계산
        int moves = 0;

        // 중간에 있는 b와 양쪽 끝의 a, c가 연속된 숫자가 아니면
        // a와 b 사이 간격, b와 c 사이 간격이 각각 1보다 클 경우 이동
        if (b - a > 1) {
            moves++;
        }
        if (c - b > 1) {
            moves++;
        }

        // 결과 출력
        System.out.println(moves);
    }
}