import java.util.Scanner;

public class Main {
    public static String change(int n, int b) {
        StringBuilder result = new StringBuilder();
        
        // N이 0이면 그대로 반환
        if (n == 0)
            return "0";
        
        // N이 0보다 큰 경우에만 변환 수행
        while (n > 0) {
            int remainder = n % b;
            
            // 나머지를 문자열에 추가
            result.insert(0, remainder);
            
            // N을 B로 나눈 몫으로 갱신
            n /= b;
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(change(n,b));
    }
}