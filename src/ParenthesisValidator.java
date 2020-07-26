import java.util.Stack;

/**
 * leetcode - https://leetcode.com/problems/valid-parentheses/
 */
public class ParenthesisValidator {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (isOpen(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (stack.empty()) {
                return false;
            } else if (!isMatchingClose(stack.pop(), s.charAt(i))) {
                return false;
            }
        }
        return stack.empty();
    }

    private static boolean isOpen(char c) {
        return (c == '[') || (c == '{') || (c =='(');
    }

    private static boolean isMatchingClose(char o, char c) {
        switch(o) {
            case '{' : return (c == '}');
            case '[' : return (c == ']');
            case '(' : return (c == ')');
            default: return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(ParenthesisValidator.isValid("()[]{}"));
        System.out.println(ParenthesisValidator.isValid("([)]"));
        System.out.println(ParenthesisValidator.isValid("{[]}"));
    }
}
