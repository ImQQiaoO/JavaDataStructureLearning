package DataStructure.Stack;

import java.util.Stack;

public class BraceMatching {
    /**
     * LeetCode20:有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     */
    public static void main(String[] args) {
        String str = "{()]";
        System.out.println(isMatch(str));
    }

    private static boolean isMatch0(String str) {
        Stack0<Character> stack0 = new Stack0<>();
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            if (a == '(') {
                stack0.push(a);
            } else if (a == ')') {
                Character pop = stack0.pop();
                if (pop == null) {
                    return false;
                }
            }
        }
        return stack0.size() == 0;
    }

    private static boolean isMatch(String s) {
        int p = 0;
        //这是Java的栈，不是自己写的
        Stack<Character> stack = new Stack<>();
        while (p < s.length()) {
            char currChar = s.charAt(p);
            if (currChar == '(') {
                stack.push(')');
            } else if (currChar == '[') {
                stack.push(']');
            } else if (currChar == '{') {
                stack.push('}');
            } else {
                if (!stack.isEmpty() && stack.peek() == currChar) {
                    stack.pop();
                } else {
                    return false;
                }
            }
            p++;
        }
        return stack.size() == 0;
    }
}