import java.util.Scanner;

    public class PalindromeCheckerApp {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            // Taking input from user
            System.out.print("Enter a string: ");
            String original = sc.nextLine();

            String reversed = "";

            // Reverse string using for loop
            for (int i = original.length() - 1; i >= 0; i--) {
                reversed = reversed + original.charAt(i);   // String concatenation
            }

            // Display reversed string
            System.out.println("Reversed string: " + reversed);

            // Compare original and reversed
            if (original.equals(reversed)) {
                System.out.println("Result: String is a palindrome");
            } else {
                System.out.println("Result: String is not a palindrome");
            }

            sc.close();
        }
    }