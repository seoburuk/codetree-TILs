import java.util.*;

class Developer {
    public boolean infect;
    public int num;
    public int countInfections;

    public Developer(int num, int k) {
        infect = false;
        this.num = num;
        this.countInfections = k;
    }

    public void infection() {
        this.infect = true;
    }
}

public class Main {
    public static int n;
    public static int[] timeX = new int[251];
    public static int[] timeY = new int[251];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int k = sc.nextInt(), p = sc.nextInt(), t = sc.nextInt();
        Developer[] d = new Developer[n];

        for (int i = 0; i < n; i ++) {
            d[i] = new Developer(i, k);
        }
        
        d[p - 1].infection();

        while (t -- > 0) {
            int time = sc.nextInt();
            int devX = sc.nextInt();
            int devY = sc.nextInt();
            timeX[time] = devX;
            timeY[time] = devY;
        }

        for (int i = 0; i < timeX.length; i ++) {
            if(timeX[i] != 0 && timeY[i] != 0) {
                if(d[timeX[i] - 1].infect && d[timeX[i] - 1].countInfections > 0) {
                    if(d[timeY[i] - 1].infect) d[timeY[i] - 1].countInfections --;
                    d[timeY[i] - 1].infection();
                    d[timeX[i] - 1].countInfections --;
                    continue;
                }
                if(d[timeY[i] - 1].infect && d[timeY[i] - 1].countInfections > 0) {
                    if(d[timeX[i] - 1].infect) d[timeX[i] - 1].countInfections --;
                    d[timeX[i] - 1].infection();
                    d[timeY[i] - 1].countInfections --;
                    continue;
                }
            }
        }

        for(int i = 0; i < n; i ++) {
            if(d[i].infect) System.out.print(1);
            else System.out.print(0);
        }
    }
}