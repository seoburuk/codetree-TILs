import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int bombs[] = new int[n];
        for(int i = 0 ; i < n; i++) {
            bombs[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> explositionCount = new HashMap<>();
        for(int i = 0; i < n; i++) {
            for(int j = i; j <= i + k && j < n; j++) {
                if(bombs[i] == bombs[j]) {
                    explositionCount.put(bombs[i], explositionCount.getOrDefault(bombs[i], 0) + 1);
                }
            }
        }

        int maxFrequency = 0;
        int max = 0;
        for(int key : explositionCount.keySet()) {
            int freq = explositionCount.get(key);
            if(freq > maxFrequency || (freq == maxFrequency && max < key)) {
                maxFrequency = freq;
                max = key;
            }
        }

        System.out.print(max);
    }
}