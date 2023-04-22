package DataStructure.Stack;

import java.util.Stack;

public class Convert {
    /**
     * 中缀表达式转后缀
     */
     /*
        思路
        1. 遇到数字, 拼串
        2. 遇到 + - * /
            - 优先级高于栈顶运算符 入栈
            - 否则将栈中高级或平级运算符出栈拼串, 本运算符入栈
        3. 遍历完成, 栈中剩余运算符出栈拼串
            - 先出栈,意味着优先运算
        4. 带 ()
            - 左括号直接入栈
            - 右括号要将栈中直至左括号为止的运算符出栈拼串

        |   |
        |   |
        |   |
        _____

        a+b
        a+b-c
        a+b*c
        a*b+c
        (a+b)*c

     */
    public static void main(String[] args) throws Exception {
        System.out.println(infixToSuffix("a+b"));
        System.out.println(infixToSuffix("a+b-c"));
        System.out.println(infixToSuffix("a+b*c"));
        System.out.println(infixToSuffix("a*b-c"));
        System.out.println(infixToSuffix("a+b/c+d*e-f"));
        System.out.println(infixToSuffix("(a+b)*c"));
        System.out.println(infixToSuffix("(a+b*c-d)*e"));
        System.out.println(infixToSuffix("a*(b+c)"));
        System.out.println(infixToSuffix("a+b*c+(d*e+f)*g"));
        System.out.println(infixToSuffix("(a+b)*(c-d)+e"));
        System.out.println(infixToSuffix("a+((b+c*d)+e)-f"));
    }

    static String infixToSuffix(String exp) throws Exception {
        Stack<Character> stack = new Stack<>();
        StringBuilder convert = new StringBuilder();
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) != '+' && exp.charAt(i) != '-' && exp.charAt(i) != '*' && exp.charAt(i) != '/'
                    && exp.charAt(i) != '(' && exp.charAt(i) != ')') {
                convert.append(exp.charAt(i));
//                if (i == exp.length() - 1) {
//                    while (stack.size() != 0) {
//                        convert.append(stack.pop());
//                    }
//                }
            } else { //如果这个字符是四则运算符或括号：
                if (stack.size() == 0) {
                    stack.push(exp.charAt(i));
                } else if (exp.charAt(i) == '(') {
                    stack.push(exp.charAt(i));
                } else if (exp.charAt(i) == ')') {
                    while (stack.size() != 0 && stack.peek() != '(') {
                        convert.append(stack.pop());
                    }
                    stack.pop();
                } else {
                    if (priority(stack.peek()) >= priority(exp.charAt(i))) { //只pop一个不行！
//                        convert.append(stack.pop());
//                        stack.push(exp.charAt(i));
                        //TODO:将优先级比当前符号高的和平级的都出栈，再将该运算符入栈
                        while (stack.size() != 0 && priority(stack.peek()) >= priority(exp.charAt(i))) {
                            convert.append(stack.pop());
                        }
                        stack.push(exp.charAt(i));
                    } else if (priority(stack.peek()) < priority(exp.charAt(i))) {
                        stack.push(exp.charAt(i));
                    }
                }
            }
            if (i == exp.length() - 1) {
                while (stack.size() != 0) {
                    convert.append(stack.pop());
                }
            }
        }
        return convert.toString();
    }

    static int priority(char operator) throws Exception {
        if (operator == '*' || operator == '/') {
            return 2;
        } else if (operator == '+' || operator == '-') {
            return 1;
        }
        return 0;
    }
}
