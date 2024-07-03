import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[] combo1 = new int[3];
        int[] combo2 = new int[3];
        
        // 첫 번째 조합 입력
        for (int i = 0; i < 3; i++) {
            combo1[i] = sc.nextInt();
        }
        
        // 두 번째 조합 입력
        for (int i = 0; i < 3; i++) {
            combo2[i] = sc.nextInt();
        }
        
        int count = 0;

        // 가능한 모든 조합 탐색
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (isWithinDistance(i, combo1[0], N) && isWithinDistance(j, combo1[1], N) && isWithinDistance(k, combo1[2], N) ||
                        isWithinDistance(i, combo2[0], N) && isWithinDistance(j, combo2[1], N) && isWithinDistance(k, combo2[2], N)) {
                        count++;
                    }
                }
            }
        }
        
        System.out.println(count);
    }
    
    // 두 숫자가 거리가 2 이내인지 확인하는 함수
    public static boolean isWithinDistance(int a, int b, int N) {
        int distance = Math.abs(a - b);
        return distance <= 2 || distance >= N - 2;
    }
}