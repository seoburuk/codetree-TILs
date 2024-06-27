import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        // 사람들의 위치와 팻말 정보를 저장할 리스트
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int position = scanner.nextInt();
            char sign = scanner.next().charAt(0);
            people.add(new Person(position, sign));
        }

        scanner.close();

        // 최대 점수를 저장할 변수
        int maxScore = 0;

        // 모든 사람의 위치를 기준으로 구간 탐색
        for (int i = 0; i < N; i++) {
            int startPosition = people.get(i).position;
            int endPosition = startPosition + K;

            int currentScore = 0;

            // 현재 구간 내에 포함된 사람들의 점수 계산
            for (Person person : people) {
                if (person.position >= startPosition && person.position <= endPosition) {
                    if (person.sign == 'G') {
                        currentScore += 1;
                    } else if (person.sign == 'H') {
                        currentScore += 2;
                    }
                }
            }

            // 최대 점수 갱신
            if (currentScore > maxScore) {
                maxScore = currentScore;
            }
        }

        // 결과 출력
        System.out.println(maxScore);
    }

    // 사람의 위치와 팻말 정보를 저장할 클래스
    static class Person {
        int position;
        char sign;

        Person(int position, char sign) {
            this.position = position;
            this.sign = sign;
        }
    }
}