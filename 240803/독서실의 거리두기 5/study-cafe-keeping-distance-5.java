import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String seats = sc.next();
        sc.close();

        // Find the maximum of the minimum distances with adding a new person
        int result = findMaxMinDistance(n, seats);
        System.out.print(result);
    }

    public static int findMaxMinDistance(int n, String seats) {
        int maxMinDistance = 0;
        
        // Iterate over all possible positions to add a new person
        for (int i = 0; i < n; i++) {
            if (seats.charAt(i) == '0') {
                // Create a new configuration with a person added at the position
                String newSeats = seats.substring(0, i) + '1' + seats.substring(i + 1);
                
                // Calculate the minimum distance in this new configuration
                int minDistance = calculateMinDistance(n, newSeats);
                
                // Update the maximum of the minimum distances
                maxMinDistance = Math.max(minDistance, maxMinDistance);
            }
        }
        
        return maxMinDistance;
    }

    public static int calculateMinDistance(int n, String newSeats) {
        int lastPerson = -1;
        int minDistance = n;
        
        // Iterate over all seats to find the minimum distance between two people
        for (int i = 0; i < n; i++) {
            if (newSeats.charAt(i) == '1') {
                if (lastPerson != -1) {
                    int distance = i - lastPerson;
                    minDistance = Math.min(distance, minDistance);
                }
                lastPerson = i;
            }
        }
        
        return minDistance;
    }
}