import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // 집의 개수
        int[] A = new int[n]; // 처음 각 집에 있는 사람 수
        int[] B = new int[n]; // 최종 각 집에 있어야 할 사람 수
        
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }
        
        int totalDistance = 0;
        int peopleDiff = 0;  // 현재까지의 사람 차이 누적치
        
        for (int i = 0; i < n; i++) {
            peopleDiff += A[i] - B[i];
            totalDistance += Math.abs(peopleDiff);
        }
        
        System.out.println(totalDistance);
    }
}