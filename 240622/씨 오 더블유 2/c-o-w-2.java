import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine().trim();

        int cntC = 0;
        int cntCO = 0;
        int cntCOW = 0;

        for(int i = 0; i < n; i++) {
            char ch = input.charAt(i);
            if(ch == 'C') {
                cntC++;
            } else if(ch == 'O') {
                cntCO += cntC;
            } else if(ch == 'W') {
                cntCOW += cntCO;
            }
            
        }

    System.out.print(cntCOW);
        
    }
}