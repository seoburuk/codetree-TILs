import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binaryString = sc.next();
        
        // 문자열을 뒤집어서 처리하기 위해 StringBuilder를 사용합니다.
        StringBuilder binary = new StringBuilder(binaryString);
        binary.reverse();

        int decimal = 0;
        // 2진수의 각 자리값에 대해 처리합니다.
        for (int i = 0; i < binary.length(); i++) {
            int bit = binary.charAt(i) - '0'; // 문자를 숫자로 변환합니다.
            decimal += bit * Math.pow(2, i); // 2의 거듭제곱을 곱하여 더합니다.
        }

        System.out.println(decimal);
    }
}