import java.util.Scanner;

public class Main {

    static class Product {
        String name;
        int code;

        public Product(String name, int code) {
            this.name = name; // Assigning parameter to instance variable
            this.code = code; // Assigning parameter to instance variable
        }
    }

    public static void main(String[] args) {
        // Scanner for user input
        Scanner sc = new Scanner(System.in);

        // Input for the first product
        String name1 = "codetree";
        int code1 = 50;

        // Input for the second product
        String name2 = sc.next();
        int code2 = sc.nextInt();

        // Creating instances of Product class
        Product product1 = new Product(name1, code1);
        Product product2 = new Product(name2, code2);

        // Output
        System.out.println("product " + product1.code + " is " + product1.name);
        System.out.println("product " + product2.code + " is " + product2.name);
    }
}