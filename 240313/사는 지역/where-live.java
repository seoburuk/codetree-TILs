import java.util.Scanner;

public class Main {
    static class Person {
        String name;
        String address;
        String city;

        public Person(String name, String address, String city) {
            this.name = name;
            this.address = address;
            this.city = city;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 사람 수 입력
        int n = sc.nextInt();
        sc.nextLine(); // 개행문자 제거

        // 입력된 사람들의 정보를 저장할 배열 생성
        Person[] people = new Person[n];

        // 정보 입력 받기
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            String name = input[0];
            String address = input[1];
            String city = input[2];
            people[i] = new Person(name, address, city);
        }

        // 사전순으로 이름이 가장 느린 사람의 정보 찾기
        Person slowestPerson = people[0];
        for (int i = 1; i < n; i++) {
            if (people[i].name.compareTo(slowestPerson.name) > 0) {
                slowestPerson = people[i];
            }
        }

        // 결과 출력
        System.out.println("name " + slowestPerson.name);
        System.out.println("addr " + slowestPerson.address);
        System.out.println("city " + slowestPerson.city);
    }
}