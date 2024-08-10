import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String seats = sc.next();
        ArrayList<Integer> availableSeats = new ArrayList<>();
        ArrayList<Integer> occupiedSeats = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(seats.charAt(i) == '0') {
                availableSeats.add(i);
            } else {
                occupiedSeats.add(i);
            }
        }   
        int maxDistance = 0;
        // 2자리 조합
        for(int i = 0; i < availableSeats.size()-1; i++) {
            for(int j = i+1; j < availableSeats.size(); j++) {
                int pos1 = availableSeats.get(i);
                int pos2 = availableSeats.get(j);

                int minDistance = Integer.MAX_VALUE;
                ArrayList<Integer> allPeople = new ArrayList<>(occupiedSeats);
                allPeople.add(pos1);
                allPeople.add(pos2);
                // all에서 가장 가까운 거리 계산
                for(int k = 0; k < allPeople.size()-1; k++) {
                    for(int l = k+1; l < allPeople.size(); l++) {
                        int distance = Math.abs(allPeople.get(k) - allPeople.get(l));
                        minDistance = Math.min(minDistance, distance);
                    }
                }
                maxDistance = Math.max(minDistance, maxDistance);
            }
        }

        System.out.print(maxDistance);
    }
}