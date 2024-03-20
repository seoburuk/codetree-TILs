import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), current = 1000, cnt = 0;
        int[] arr = new int[2001];

        for (int i = 0; i < num; i++) {
            int step = sc.nextInt();
            char direct = sc.next().charAt(0);
            switch (direct) {
                case 'R':
                    for (int j = current; j < current + step; j++) {
                        arr[j]++;
                    }
                    current += step;
                    break;
                case 'L':
                    for (int j = current; j > current - step; j--) {
                        arr[j]++;
                    }
                    current -= step;
                    break;
                default:
                    break;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > 1) {
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}