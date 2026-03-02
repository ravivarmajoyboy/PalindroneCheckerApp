import java.util.*;

public class PalindromeCheckerApp{

    // Stack-based palindrome
    public static boolean stackPalindrome(String input) {
        String str = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) stack.push(ch);
        for (char ch : str.toCharArray()) {
            if (ch != stack.pop()) return false;
        }
        return true;
    }

    // Deque-based palindrome
    public static boolean dequePalindrome(String input) {
        String str = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : str.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }

    // Recursive palindrome
    public static boolean recursivePalindrome(String input, int start, int end) {
        String str = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return recursivePalindrome(str, start + 1, end - 1);
    }

    // Two-pointer iterative palindrome
    public static boolean twoPointerPalindrome(String input) {
        String str = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string for performance test: ");
        String input = scanner.nextLine();

        // Map to store execution times
        Map<String, Long> performanceMap = new LinkedHashMap<>();

        // Stack-based
        long start = System.nanoTime();
        stackPalindrome(input);
        long end = System.nanoTime();
        performanceMap.put("Stack", end - start);

        // Deque-based
        start = System.nanoTime();
        dequePalindrome(input);
        end = System.nanoTime();
        performanceMap.put("Deque", end - start);

        // Recursive
        start = System.nanoTime();
        recursivePalindrome(input, 0, input.replaceAll("[^a-zA-Z0-9]", "").length() - 1);
        end = System.nanoTime();
        performanceMap.put("Recursive", end - start);

        // Two-pointer
        start = System.nanoTime();
        twoPointerPalindrome(input);
        end = System.nanoTime();
        performanceMap.put("Two-Pointer", end - start);

        // Display results
        System.out.println("\nPerformance Comparison (in nanoseconds):");
        performanceMap.forEach((algo, time) -> System.out.println(algo + ": " + time));

        scanner.close();
    }
}