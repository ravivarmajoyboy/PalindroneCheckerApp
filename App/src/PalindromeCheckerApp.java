import java.util.Scanner;
import java.util.Stack;

// PalindromeChecker class encapsulates palindrome logic
class PalindromeChecker {

    // Public method exposed to client
    public boolean checkPalindrome(String input) {
        // Normalize input (case-insensitive, ignore spaces/punctuation)
        String normalized = normalize(input);

        // Use internal stack-based palindrome check
        return isPalindromeUsingStack(normalized);
    }

    // Private helper: normalize string
    private String normalize(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    // Private helper: stack-based palindrome check
    private boolean isPalindromeUsingStack(String str) {
        Stack<Character> stack = new Stack<>();

        // Push all characters onto stack
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        // Compare characters while popping
        for (char ch : str.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// Client code
public class PalindromeCheckerApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check palindrome: ");
        String userInput = scanner.nextLine();

        // Create PalindromeChecker object
        PalindromeChecker checker = new PalindromeChecker();

        // Call checkPalindrome method
        boolean isPalindrome = checker.checkPalindrome(userInput);

        // Display result
        if (isPalindrome) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}