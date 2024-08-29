import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] result = new int[n];
        greatCombination(k,n,0,result);
    }
    public static void greatCombination(int k, int n, int depth, int[] result) {
        if(depth == n) {
            for(int i = 0; i < n; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 1; i <= k; i++) {
            result[depth] = i;
            greatCombination(k,n,depth+1,result);
        }
    }
}