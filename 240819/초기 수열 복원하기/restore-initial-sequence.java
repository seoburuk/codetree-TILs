import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] sum = new int[n-1];
        for(int i = 0; i < n-1; i++) {
            sum[i] = sc.nextInt();
        }
        // Try every possible first element for the sequence
        for(int first = 1; first<=n; first++) {
            int[] sequence = new int[n];
            boolean valid = true;
            HashSet<Integer> used = new HashSet<>();
            // Set the frist element
            sequence[0] = first;
            used.add(first);
            // Construct the rest of the sequnece
            for(int i = 1; i < n; i++) {
                sequence[i] = sum[i-1] - sequence[i-1];
                // Check if the current valid
                if(sequence[i] < 1 || sequence[i] > n|| used.contains(sequence[i])) {
                    valid = false;
                    break;
                }
                used.add(sequence[i]);
            }
            // if the seqeunce is valid print it and exit
            if(valid == true) {
                for(int num : sequence) {
                    System.out.print(num + " ");
                }
            }
            
        }
        return; // Exit after finding the valid sequence
    }
}