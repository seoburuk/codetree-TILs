import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next(); // Scanner 객체로부터 문자열 입력 받기
        char[] chars = str.toCharArray(); // 문자열을 문자 배열로 변환
        Arrays.sort(chars); // 문자 배열을 정렬
        String sortedStr = new String(chars); // 정렬된 문자 배열을 다시 문자열로 변환
        System.out.println(sortedStr); // 정렬된 문자열 출력
    }
}