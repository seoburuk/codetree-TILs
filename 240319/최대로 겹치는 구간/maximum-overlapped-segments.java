import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 줄 개수
        int[][] segement = new int[n][2]; // 선분정보 저장 배열

        for(int i = 0; i < n; i++) {
            segement[i][0] = sc.nextInt(); // 시작점
            segement[i][1] = sc.nextInt(); // 끝지점

        } 

        int[] pointCount = new int[201]; // 지점마다 겹치는지 저장하는 배열
        // 션분을 돌면서 시작지점에 +1 마지막 지점에 -1 하면서 순회
        for(int i = 0; i < n; i++) {
            pointCount[segement[i][0]]++;
            pointCount[segement[i][1]]--;
        }

        int maxSegment=0;
        int curSegment=0;

        for(int i = 0; i< n; i++) {
            curSegment += pointCount[i];
            maxSegment = Math.max(curSegment, maxSegment);


        }
        System.out.println(maxSegment);
    }
}