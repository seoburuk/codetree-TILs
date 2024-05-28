import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 여기에 코드를 작성해주세요.
        int cnt = 0;
        String A = sc.nextLine();
        int length = A.length();

        for(int i = 0; i < length; i++) {
           if(A.charAt(i) == '(') {
            for(int j = i+1; j < length; j++) {
                if(A.charAt(j) == ')') {
                    cnt++;
                }
            }
           }
        }

        System.out.println(cnt);
    }
}