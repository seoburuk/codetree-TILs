import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N과 L을 입력받음
        int N = sc.nextInt();
        int L = sc.nextInt();

        // N개의 숫자를 입력받음
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }

        // H 점수를 구하는 함수
        System.out.println(getMaxHScore(a, N, L));
    }

    // H 점수를 구하는 함수
    public static int getMaxHScore(int[] a, int N, int L) {
        int maxH = 0;

        // 현재 배열의 H 점수를 먼저 계산
        maxH = calculateHScore(a, N);

        // 숫자의 값을 1씩 증가시키는 작업
        // L개의 서로 다른 원소의 값을 1씩 증가시킨 후 H 점수를 다시 계산하여 최댓값 찾기
        for (int i = 0; i < (1 << N); i++) {
            if (Integer.bitCount(i) <= L) {  // 선택한 숫자의 개수가 L 이하일 때만 진행
                int[] temp = a.clone();  // 원본 배열 복사
                for (int j = 0; j < N; j++) {
                    if ((i & (1 << j)) != 0) {
                        temp[j]++;  // 해당 숫자의 값을 1 증가시킴
                    }
                }
                maxH = Math.max(maxH, calculateHScore(temp, N));  // H 점수 갱신
            }
        }

        return maxH;
    }

    // H 점수를 계산하는 함수
    public static int calculateHScore(int[] arr, int N) {
        for (int H = N; H >= 0; H--) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] >= H) {
                    count++;
                }
            }
            if (count >= H) {
                return H;
            }
        }
        return 0;
    }
}