import java.util.Scanner;

public class Main {
    public static int[] dx = new int[]{0, 1, 0, -1}; // East, South, West, North
    public static int[] dy = new int[]{1, 0, -1, 0};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String commands = sc.nextLine();
        
        int x = 0, y = 0;
        int direction = 0; // Start facing North
        
        for (char command : commands.toCharArray()) {
            if (command == 'L') {
                direction = (direction + 3) % 4; // Turn left
            } else if (command == 'R') {
                direction = (direction + 1) % 4; // Turn right
            } else if (command == 'F') {
                x += dx[direction];
                y += dy[direction];
            }
        }
        
        System.out.println(x + " " + y);
    }
}