import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[15];
        for(int i = 0; i < 15; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        for(int A = 1; A <= 40; A++) {
            for(int B = A; B <= 40; B++) {
                for(int C = B; C <= 40; C++) {
                    for(int D = C; D <= 40; D++) {
                        int[] CalcuatedSums = {
                            A, B, C, D,
                            A + B, B + C, C + D, D + A, A + C, B + D,
                            A + B + C, A + B + D, A + C + D, B + C + D,
                            A + B + C + D
                        };

                        Arrays.sort(CalcuatedSums);
                        if(Arrays.equals(CalcuatedSums, nums)) {
                            System.out.print(A + " " + B + " " + C + " " + D);
                            return;
                        }
                    } 
                }
            }
        }
        
    }
}