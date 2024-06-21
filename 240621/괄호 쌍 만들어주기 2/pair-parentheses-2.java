import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner sc = new Scanner(System.in);
        
        // Read the input string
        String input = sc.nextLine().trim();
        
        // Call the function to count valid pairs and print the result
        System.out.println(countBracketPairs(input));
    }

    public static int countBracketPairs(String A) {
        int n = A.length();
        int count = 0;

        // Loop over each possible position for the first pair '(('
        for (int i = 0; i <= n - 4; i++) {
            if (A.substring(i, i + 2).equals("((")) {  // Check for '(('
                // Loop over each possible position for the second pair '))'
                for (int j = i + 2; j <= n - 2; j++) {
                    if (A.substring(j, j + 2).equals("))")) {  // Check for '))'
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}