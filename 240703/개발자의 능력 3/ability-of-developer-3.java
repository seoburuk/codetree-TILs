import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] people = new int[6];
        int sum = 0;

        // 능력치를 입력받고 전체 합계를 계산
        for (int i = 0; i < 6; i++) {
            people[i] = sc.nextInt();
            sum += people[i];
        }

        int minDifference = Integer.MAX_VALUE;

        // 모든 가능한 3명 조합을 탐색
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                for (int k = j + 1; k < 6; k++) {
                    // 첫 번째 팀의 합계를 계산
                    int team1Sum = people[i] + people[j] + people[k];
                    
                    // 두 번째 팀의 합계는 전체 합계에서 첫 번째 팀의 합계를 뺀 값
                    int team2Sum = sum - team1Sum;
                    
                    // 두 팀의 합계 차이를 계산하고 최소값 갱신
                    int diff = Math.abs(team1Sum - team2Sum);
                    if (diff < minDifference) {
                        minDifference = diff;
                    }
                }
            }
        }

        // 최소 차이를 출력
        System.out.println(minDifference);
    }
}