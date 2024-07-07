import java.util.Scanner;

public class Main {
    // Function to convert a three-digit number to an array of its digits
    public static int[] numberToArray(int number) {
        int[] arr = new int[3];
        arr[0] = number / 100;
        arr[1] = (number / 10) % 10;
        arr[2] = number % 10;
        return arr;
    }

    // Function to count 1 and 2 based on the rules
    public static boolean isValid(int[] guessArr, int[] testArr, int oneCount, int twoCount) {
        int countOne = 0;
        int countTwo = 0;

        // Check for 1 counts
        for (int i = 0; i < 3; i++) {
            if (guessArr[i] == testArr[i]) {
                countOne++;
            }
        }

        // Check for 2 counts
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && guessArr[i] == testArr[j]) {
                    countTwo++;
                }
            }
        }

        return countOne == oneCount && countTwo == twoCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] data = new int[n][3];

        for (int i = 0; i < n; i++) {
            data[i][0] = sc.nextInt();
            data[i][1] = sc.nextInt();
            data[i][2] = sc.nextInt();
        }

        int possibleCount = 0;

        // Generate all possible three-digit numbers with unique digits from 1 to 9
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (j == i) continue;
                for (int k = 1; k <= 9; k++) {
                    if (k == i || k == j) continue;
                    
                    int number = i * 100 + j * 10 + k;
                    boolean valid = true;

                    // Check if this number is valid for all the given constraints
                    for (int l = 0; l < n; l++) {
                        int[] guessArr = numberToArray(number);
                        int[] testArr = numberToArray(data[l][0]);
                        int oneCount = data[l][1];
                        int twoCount = data[l][2];

                        if (!isValid(guessArr, testArr, oneCount, twoCount)) {
                            valid = false;
                            break;
                        }
                    }

                    if (valid) {
                        possibleCount++;
                    }
                }
            }
        }

        System.out.println(possibleCount);
    }
}