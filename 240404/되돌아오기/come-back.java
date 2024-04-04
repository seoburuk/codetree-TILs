import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // Number of movements
        int x = 0, y = 0; // Initial point
        int[] dx = {0, 1, -1, 0}; // Change in x-coordinate based on direction
        int[] dy = {-1, 0, 0, 1}; // Change in y-coordinate based on direction
        HashMap<Character, Integer> dic = new HashMap<>(); // Map direction to number
        dic.put('W', 0); dic.put('N', 1); dic.put('S', 2); dic.put('E', 3);
        
        int t = 0; // Time counter
        int answer = -1; // Final answer
        
        sc.nextLine(); // consume newline character after reading N
        for (int i = 0; i < N; i++) {
            String[] info = sc.nextLine().split(" ");
            char dir = info[0].charAt(0); // Direction
            int dirNum = dic.get(dir); // Number corresponding to direction
            int ds = Integer.parseInt(info[1]); // Distance
            
            for (int j = 0; j < ds; j++) {
                int nx = x + dx[dirNum]; // New x-coordinate
                int ny = y + dy[dirNum]; // New y-coordinate
                t++; // Increment time for each step
                x = nx; y = ny; // Update position
                if (x == 0 && y == 0) { // Check if starting point reached
                    answer = t;
                    break;
                }
            }
            if (answer != -1) { // If starting point reached, break outer loop
                break;
            }
        }
        
        System.out.println(answer); // Print time taken or -1 if not returned to starting point
    }
}