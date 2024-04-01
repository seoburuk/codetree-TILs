import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        int x = 0, y = 0;

        for (int i = 0; i < N; i++) {
            String[] move = scanner.nextLine().split(" ");
            char direction = move[0].charAt(0);
            int distance = Integer.parseInt(move[1]);

            switch (direction) {
                case 'N':
                    y += distance;
                    break;
                case 'S':
                    y -= distance;
                    break;
                case 'E':
                    x += distance;
                    break;
                case 'W':
                    x -= distance;
                    break;
            }
        }

        System.out.println(x + " " + y);
    }
}