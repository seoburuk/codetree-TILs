import java.util.Scanner;

public class Main {
    public static final int DIR_NUM = 4;
    public static int n, x, y;
    public static int[] dx = new int[]{0, -1, 0, 1}; // 북, 서, 남, 동
    public static int[] dy = new int[]{1, 0, -1, 0};

    public static int ans = -1;
    public static int elapsedTime;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String commands = sc.next();

        // 초기 위치 설정
        x = 0;
        y = 0;

        // 초기 방향 설정 (북쪽)
        int dir = 0;

        // 경과 시간 초기화
        elapsedTime = 0;

        // 명령어 수행
        for (int i = 0; i < commands.length(); i++) {
            char cmd = commands.charAt(i);
            if (cmd == 'L') {
                // 왼쪽으로 90도 회전
                dir = (dir + 1) % DIR_NUM;
                elapsedTime++;
            } else if (cmd == 'R') {
                // 오른쪽으로 90도 회전
                dir = (dir + 3) % DIR_NUM;
                elapsedTime++;
            } else if (cmd == 'F') {
                // 현재 방향으로 한 칸 이동
                x += dx[dir];
                y += dy[dir];
                // 경과 시간 증가
                elapsedTime++;
                // 처음 위치로 되돌아온 경우
                if (x == 0 && y == 0) {
                    ans = elapsedTime;
                    break;
                }
            }
        }

        // 결과 출력
        System.out.println(ans);
    }
}