import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
//        System.out.println("Scanner Example");
        Scanner keyboardScanner = new Scanner(System.in);
//        System.out.print("Enter a number? ");
//        int number = keyboardScanner.nextInt();
//        System.out.println(String.format("You just entered %s", number));

        // "Enter a String? "
//        System.out.print("Enter a string? ");
//        String string = keyboardScanner.nextLine();
        // nextLine bat ki tu dac biet tru Enter
//        System.out.println(String.format("You just entered %s", string));

//        System.out.print("Operation : ");
//        String sign = keyboardScanner.nextLine();
        // int, float, double, byte ==
        // String, Map
//        if (sign.equals("+")) {
//            System.out.println("Add");
//        }
//        for (int i = 0; i < 4; i++) {

//        while (true) { //Game loop
//            System.out.print("Enter a : ");
//            int a = keyboardScanner.nextInt();
//            System.out.print("Enter b : ");
//            int b = keyboardScanner.nextInt();
//
//            System.out.print("Operation : ");   // Operation = sign
//            String sign = keyboardScanner.next(); //nextLine nho Enter cu khong dung duoc
//
//            if (sign.equals("+")) {
//                System.out.println("a + b = ");
//            }
//            else if (sign.equals("-")) {
//                System.out.println(a - b);
//            }
//            else if (sign.equals("*")) {
//                System.out.println(a * b);
//            }
//            else if (sign.equals("/")) {
//                System.out.println(a / b);
//            }
//        }
        System.out.print("Number of star : ");
        int n = keyboardScanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print(" * ");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(" * ");
           System.out.print(" x ");
        }
        System.out.println();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" * ");
            }
            System.out.println("\n");
        }
        System.out.println("m = ");
        int m = keyboardScanner.nextInt();
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" * ");
            }
            System.out.print("\n");
        }
    }
}
