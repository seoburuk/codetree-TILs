import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 처리
        int N = sc.nextInt();
        List<int[]> people = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int position = sc.nextInt();
            char type = sc.next().charAt(0);
            people.add(new int[]{position, type == 'G' ? 1 : -1});
        }
        sc.close();

        // 위치 기준으로 정렬
        Collections.sort(people, Comparator.comparingInt(a -> a[0]));

        int maxSize = 0;

        // 모든 구간을 확인
        for (int start = 0; start < N; start++) {
            int countG = 0;
            int countH = 0;
            for (int end = start; end < N; end++) {
                if (people.get(end)[1] == 1) countG++;
                else countH++;

                if (countG == countH || countG == 0 || countH == 0) {
                    int size = people.get(end)[0] - people.get(start)[0];
                    if (countG + countH == 1) size = 0;
                    maxSize = Math.max(maxSize, size);
                }
            }
        }

        // 결과 출력
        System.out.println(maxSize);
    }
}