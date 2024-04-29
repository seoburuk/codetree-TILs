import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Robot A
        int m = sc.nextInt(); // Robot B
        int[] arrA = new int[n * 1000];
        int[] arrB = new int[m * 1000];

        int time = 0;
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0); // Corrected

            for(int j = 0; j < t; j++) {
                if(d == 'L') {
                    cnt = -1 * t;
                    arrA[time] = cnt; // Corrected
                } else {
                    cnt = 1 * t;
                    arrA[time] = cnt; // Corrected
                }
                time++; // Increment time
            }
        }

        for(int i = 0; i < m; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0); // Corrected

            for(int j = 0; j < t; j++) {
                if(d == 'L') {
                    cnt = -1 * t;
                    arrB[time] = cnt; // Corrected
                } else {
                    cnt = 1 * t;
                    arrB[time] = cnt; // Corrected
                }
                time++; // Increment time
            }
        }

        int cnt = 0;
        int[] diff = new int[time];

        for(int i = 0; i < time; i++) {
            diff[i] = arrA[i] - arrB[i];
            if(diff[i-1] != 0 && diff[i] == 0) {
                cnt++;
            } 
        }

        System.out.println(cnt);
    }
}