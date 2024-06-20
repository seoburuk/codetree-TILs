import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 스캐너를 사용하여 입력을 받습니다.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] people = new int[n];
        
        for (int i = 0; i < n; i++) {
            people[i] = sc.nextInt();
        }
        
        int minTotalDistance = Integer.MAX_VALUE;
        
        // 각 방을 시작점으로 시도합니다.
        for (int start = 0; start < n; start++) {
            int totalDistance = 0;
            
            // 각 방에 대해 현재 시작점에서 해당 방까지의 거리를 계산합니다.
            for (int i = 0; i < n; i++) {
                int roomIndex = (start + i) % n;
                totalDistance += people[roomIndex] * i;
            }
            
            // 최소 거리를 갱신합니다.
            if (totalDistance < minTotalDistance) {
                minTotalDistance = totalDistance;
            }
        }
        
        // 최소 거리를 출력합니다.
        System.out.println(minTotalDistance);
        sc.close();
    }
}