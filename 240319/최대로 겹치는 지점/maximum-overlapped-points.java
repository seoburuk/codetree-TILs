import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 선분의 개수
        int[][] segments = new int[n][2]; // 선분의 정보를 저장할 배열

        // 선분 정보 입력 받기
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt(); // 선분의 시작점
            segments[i][1] = sc.nextInt(); // 선분의 끝점
        }

        // 각 지점에서 겹치는 선분의 수를 기록할 배열
        int[] pointCount = new int[101];

        // 각 선분에 대해 시작점과 끝점을 기록하여 겹치는 선분의 수를 증가시킴
        for (int i = 0; i < n; i++) {
            for (int j = segments[i][0]; j <= segments[i][1]; j++) {
                pointCount[j]++;
            }
        }

        // 가장 많이 겹치는 지점에서의 선분 개수를 구함
        int maxSegments = 0;
        for (int i = 0; i < 101; i++) {
            maxSegments = Math.max(maxSegments, pointCount[i]);
        }

        System.out.println(maxSegments);
    }
}