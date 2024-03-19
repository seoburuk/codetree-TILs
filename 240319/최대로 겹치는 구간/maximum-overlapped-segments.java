import java.util.*;

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

        // 각 점마다 몇 개의 선분이 겹치는지를 저장할 배열
        int[] pointCount = new int[201];

        // 선분들을 돌면서 시작점에 +1, 끝점에 -1을 해주어서 겹치는 구간을 체크
        for (int i = 0; i < n; i++) {
            pointCount[segments[i][0] + 100]++; // 시작점에 +1
            pointCount[segments[i][1] + 100]--; // 끝점에 -1
        }

        // 누적합을 통해 겹치는 구간을 찾고, 그 중에서 최대로 겹치는 구간의 선분 개수를 구함
        int maxSegments = 0;
        int currentSegments = 0;
        for (int i = 0; i < 201; i++) {
            currentSegments += pointCount[i];
            maxSegments = Math.max(maxSegments, currentSegments);
        }

        System.out.println(maxSegments);
    }
}