import java.util.Scanner;

public class PalindromeCheckerApp  {

    // Method to check palindrome using two-pointer technique
    public static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Normalize input: lowercase, remove spaces and non-alphanumeric characters
        input = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        boolean result = isPalindrome(input);

        if (result) {
            System.out.println("The string is a Palindrome (case & space ignored).");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}