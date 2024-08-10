import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int bombs[] = new int[n];
        for(int i = 0 ; i < n; i++) {
            bombs[i] = sc.nextInt();
        }

        // 폭발 횟수 기록을 위한 맵
        HashMap<Integer, Integer> explositionCount = new HashMap<>();

        // 폭발 조건 체크 및 기록
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j <= i + k && j < n; j++) {
                if(bombs[i] == bombs[j]) {
                    explositionCount.put(bombs[i], explositionCount.getOrDefault(bombs[i], 0) + 1);
                }
            }
        }

        // 최다 빈도 폭탄 찾기
        int maxFrequency = 0;
        int max = 0;
        for(int key : explositionCount.keySet()) {
            int freq = explositionCount.get(key);
            if(freq > maxFrequency || (freq == maxFrequency && max < key)) {
                maxFrequency = freq;
                max = key;
            }
        }

        // 결과 출력
        System.out.print(max);
    }
}