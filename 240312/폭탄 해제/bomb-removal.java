import java.util.Scanner;

public class Main {
    static class Bomb {
        String code;
        char color;
        int sec;

        public Bomb(String code, char color, int sec) {
            this.code = code;
            this.color = color;
            this.sec = sec;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String code = sc.next();
        char color = sc.next().charAt(0);
        int sec = sc.nextInt();

        Bomb bomb = new Bomb(code, color, sec);

        System.out.println("code : " + bomb.code);
        System.out.println("color : " + bomb.color);
        System.out.println("second : " + bomb.sec);
    }
}