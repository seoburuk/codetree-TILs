import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 처리
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] candyMap = new int[101];
        
        for (int i = 0; i < N; i++) {
            int candies = sc.nextInt();
            int position = sc.nextInt();
            candyMap[position] += candies;
        }

        int maxCandies = 0;

        // 가능한 모든 중심점 c를 탐색합니다.
        for (int c = 0; c <= 100; c++) {
            int currentCandies = 0;
            int start = Math.max(0, c - K);
            int end = Math.min(100, c + K);

            // 해당 구간의 사탕 개수를 계산합니다.
            for (int i = start; i <= end; i++) {
                currentCandies += candyMap[i];
            }

            // 최대 사탕 개수를 업데이트합니다.
            if (currentCandies > maxCandies) {
                maxCandies = currentCandies;
            }
        }

        // 결과 출력
        System.out.println(maxCandies);
    }
}