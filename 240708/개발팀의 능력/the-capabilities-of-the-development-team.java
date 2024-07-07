import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] abilities = new int[5];
        
        for (int i = 0; i < 5; i++) {
            abilities[i] = sc.nextInt();
        }

        int minDifference = Integer.MAX_VALUE;
        boolean foundValidDivision = false;

        // Generate all combinations for the first team of 2
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                // Generate all combinations for the second team of 2
                for (int k = 0; k < 5; k++) {
                    if (k == i || k == j) continue;
                    for (int l = k + 1; l < 5; l++) {
                        if (l == i || l == j) continue;
                        
                        // The remaining member forms the third team
                        int m = 10 - i - j - k - l; // Sum of indices 0 to 4 is 10, so the remaining index is 10 - sum of chosen indices
                        
                        // Calculate the sum of abilities for each team
                        int team1 = abilities[i] + abilities[j];
                        int team2 = abilities[k] + abilities[l];
                        int team3 = abilities[m];

                        // Check if all team abilities are unique
                        if (team1 != team2 && team1 != team3 && team2 != team3) {
                            foundValidDivision = true;
                            // Calculate the current difference between max and min team abilities
                            int maxTeamAbility = Math.max(team1, Math.max(team2, team3));
                            int minTeamAbility = Math.min(team1, Math.min(team2, team3));
                            int currentDifference = maxTeamAbility - minTeamAbility;

                            // Update the minimum difference
                            if (currentDifference < minDifference) {
                                minDifference = currentDifference;
                            }
                        }
                    }
                }
            }
        }

        // Output the result
        if (foundValidDivision) {
            System.out.println(minDifference);
        } else {
            System.out.println(-1);
        }
    }
}