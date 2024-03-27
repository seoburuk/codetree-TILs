import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // grid 배열 선언 및 초기화
        boolean[][] grid = new boolean[2001][2001];

        // 각 직사각형의 좌표 입력 받기
        String[] A_coords = sc.nextLine().split(" ");
        String[] B_coords = sc.nextLine().split(" ");
        String[] M_coords = sc.nextLine().split(" ");

        // 좌표를 정수로 변환
        int Ax1 = Integer.parseInt(A_coords[0])+1000;
        int Ay1 = Integer.parseInt(A_coords[1])+1000;
        int Ax2 = Integer.parseInt(A_coords[2])+1000;
        int Ay2 = Integer.parseInt(A_coords[3])+1000;

        int Bx1 = Integer.parseInt(B_coords[0])+1000;
        int By1 = Integer.parseInt(B_coords[1])+1000;
        int Bx2 = Integer.parseInt(B_coords[2])+1000;
        int By2 = Integer.parseInt(B_coords[3])+1000;

        int Mx1 = Integer.parseInt(M_coords[0])+1000;
        int My1 = Integer.parseInt(M_coords[1])+1000;
        int Mx2 = Integer.parseInt(M_coords[2])+1000;
        int My2 = Integer.parseInt(M_coords[3])+1000;

        // A와 B가 덮이는 부분을 grid에 true로 표시
        for (int i = Ax1; i < Ax2; i++) {
            for (int j = Ay1; j < Ay2; j++) {
                grid[i][j] = true;
            }
        }
        for (int i = Bx1; i < Bx2; i++) {
            for (int j = By1; j < By2; j++) {
                grid[i][j] = true;
            }
        }

        // M이 덮이는 부분을 grid에서 false로 표시
        for (int i = Mx1; i < Mx2; i++) {
            for (int j = My1; j < My2; j++) {
                grid[i][j] = false;
            }
        }

        // 겹치지 않은 부분의 넓이 계산
        int uncovered_area = 0;
        for (int i = 0; i < 2001; i++) {
            for (int j = 0; j < 2001; j++) {
                if (grid[i][j]) {
                    uncovered_area++;
                }
            }
        }

        // 결과 출력
        System.out.println(uncovered_area);
    }
}