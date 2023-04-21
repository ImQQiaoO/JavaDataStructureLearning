package DataStructure.Stack;

import java.util.Objects;
import java.util.Stack;

public class SolvingReversePolish {
    //逆波兰式求值
    public static void main(String[] args) {
        //3*(17-15)+18/6
        String[] n1 = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        String[] n = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
//        System.out.println(calculate(n));
        System.out.println(evalPRN(n));
//        System.out.println(evalPRN1(n));
    }

    private static int calculate(String[] n) {
        Stack0<Integer> stack0 = new Stack0<>();
        for (String s : n) {
            if (s.matches("\\d+")) { //这个正则表达式只能匹配到正数，这是错的。
                stack0.push(Integer.parseInt(s));
            } else {
                int num1 = stack0.pop();
                int num2 = stack0.pop();
                int result = switch (s) {
                    case "+" -> num1 + num2;
                    case "-" -> num2 - num1;
                    case "*" -> num1 * num2;
                    case "/" -> num2 / num1;
                    default -> 0;
                };
                stack0.push(result);
            }
        }
        return stack0.pop();
    }

    /**
     * LeetCode 150
     *
     * @param tokens
     * @return
     */
    private static int evalPRN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (token.matches("^-?\\d+$")) {
                stack.push(token);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                if (Objects.equals(token, "+")) stack.push(String.valueOf(num1 + num2));
                if (Objects.equals(token, "-")) stack.push(String.valueOf(num2 - num1));
                if (Objects.equals(token, "*")) stack.push(String.valueOf(num1 * num2));
                if (Objects.equals(token, "/")) stack.push(String.valueOf(num2 / num1));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private static int evalPRN1(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        for (String t : tokens) {
            switch (t) {
                case "+" -> {
                    Integer b = numbers.pop();
                    Integer a = numbers.pop();
                    numbers.push(a + b);
                }
                case "-" -> {
                    Integer b = numbers.pop();
                    Integer a = numbers.pop();
                    numbers.push(a - b);
                }
                case "*" -> {
                    Integer b = numbers.pop();
                    Integer a = numbers.pop();
                    numbers.push(a * b);
                }
                case "/" -> {
                    Integer b = numbers.pop();
                    Integer a = numbers.pop();
                    numbers.push(a / b);
                }
                default -> numbers.push(Integer.parseInt(t));
            }
        }
        return numbers.pop();
    }
}
