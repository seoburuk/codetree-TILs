import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 이진수 입력 받기
        String a = sc.next();
        
        // 최댓값 찾기
        int maxOriginalNumber = findMaxOriginalNumber(a);
        
        // 결과 출력
        System.out.println(maxOriginalNumber);
    }
    
    public static int findMaxOriginalNumber(String a) {
        int maxValue = 0;
        int n = a.length();
        
        // 각 자리의 값을 바꿔가며 최댓값 찾기
        for (int i = 0; i < n; i++) {
            // 새로운 이진수 문자열 만들기
            StringBuilder sb = new StringBuilder(a);
            char ch = a.charAt(i);
            if (ch == '0') {
                sb.setCharAt(i, '1');
            } else {
                sb.setCharAt(i, '0');
            }
            String newA = sb.toString();
            
            // 새로운 이진수를 십진수로 변환
            int newValue = Integer.parseInt(newA, 2);
            
            // 최대값 갱신
            if (newValue > maxValue) {
                maxValue = newValue;
            }
        }
        
        return maxValue;
    }
}