import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static class Person implements Comparable<Person> {
        String name;
        int height;
        int weight;

        public Person(String name, int height, int weight) {
            this.name = name;
            this.height = height;
            this.weight = weight;
        }

        // 키를 기준으로 정렬하기 위해 compareTo 메서드를 오버라이드합니다.
        @Override
        public int compareTo(Person other) {
            return Integer.compare(this.height, other.height);
        }

        // 출력을 위해 toString 메서드를 오버라이드합니다.
        @Override
        public String toString() {
            return name + " " + height + " " + weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Person[] people = new Person[n];

        // 정보 입력 받기
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int height = sc.nextInt();
            int weight = sc.nextInt();
            people[i] = new Person(name, height, weight);
        }

        // 키를 기준으로 오름차순 정렬
        Arrays.sort(people);

        // 결과 출력
        for (Person person : people) {
            System.out.println(person);
        }
    }
}