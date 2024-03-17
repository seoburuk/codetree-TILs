import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int blocks[] = new int[n];

        for(int i = 0; i < k; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            for (int j = start -1 ; j < end; j++) { // 수정된 부분
                blocks[j]++;
            }
        }
        int maxBlock = 0;
        for (int block : blocks) {
            if(maxBlock < block) {
                maxBlock = block;
            }
        }
        System.out.println(maxBlock);
    }
}