package binary_searchtree;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
   

    public static boolean isBalancedBrackets(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if ((ch == ')' && top != '(') || (ch == ']' && top != '[') || (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isBalancedBrackets(input)) {
            System.out.println("The entered string has balanced brackets.");
        } else {
            System.out.println("The entered string does not contain balanced brackets.");
        }
    }
}
