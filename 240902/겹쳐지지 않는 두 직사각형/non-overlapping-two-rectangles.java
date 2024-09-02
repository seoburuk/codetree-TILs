import java.util.Scanner;

public class Main {
    static int[][] grid;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        grid = new int[n][m];
        
        // 그리드 입력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        int maxSum = Integer.MIN_VALUE;
        
        // 첫 번째 직사각형을 정의하는 모든 경우의 수
        for (int x1 = 0; x1 < n; x1++) {
            for (int y1 = 0; y1 < m; y1++) {
                for (int x2 = x1; x2 < n; x2++) {
                    for (int y2 = y1; y2 < m; y2++) {
                        int sum1 = calculateSum(x1, y1, x2, y2);
                        
                        // 두 번째 직사각형을 정의하는 모든 경우의 수
                        for (int x3 = 0; x3 < n; x3++) {
                            for (int y3 = 0; y3 < m; y3++) {
                                for (int x4 = x3; x4 < n; x4++) {
                                    for (int y4 = y3; y4 < m; y4++) {
                                        if (!overlap(x1, y1, x2, y2, x3, y3, x4, y4)) {
                                            int sum2 = calculateSum(x3, y3, x4, y4);
                                            maxSum = Math.max(maxSum, sum1 + sum2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        System.out.println(maxSum);
    }
    
    // 두 직사각형이 겹치는지 확인하는 함수
    public static boolean overlap(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        return !(x2 < x3 || x4 < x1 || y2 < y3 || y4 < y1);
    }
    
    // 직사각형의 합을 계산하는 함수
    public static int calculateSum(int x1, int y1, int x2, int y2) {
        int sum = 0;
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                sum += grid[i][j];
            }
        }
        return sum;
    }
}