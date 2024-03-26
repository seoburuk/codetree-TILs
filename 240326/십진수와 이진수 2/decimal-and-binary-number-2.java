import java.util.Scanner;

public class Main {
    
    // Function to convert binary to decimal
    public static int binaryToDemical(String binary) { // Corrected the method name to binaryToDemical
        int demical = 0;
        int n = binary.length();
        for(int i = 0; i < n; i++) {
            if(binary.charAt(i) == '1') {
                demical += Math.pow(2, n - i -1);
            }
        }
        return demical;
    }

    // Function to convert decimal to binary
    public static String demicalToBinary(int demical) { // Corrected the method name to demicalToBinary
        StringBuilder binary = new StringBuilder();
        while(demical > 0) {
            binary.insert(0, demical % 2);
            demical /= 2;
        }
        return binary.toString();
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String binary = sc.nextLine(); // Read binary num to String
        int demical = binaryToDemical(binary); // Convert binary to decimal;
        int result = demical * 17; // Multiply by 17times
        String binaryResult = demicalToBinary(result); // Convert result back to binary
        System.out.println(binaryResult);
    }
}