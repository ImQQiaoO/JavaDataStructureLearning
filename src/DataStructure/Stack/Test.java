package DataStructure.Stack;

public class Test {
    public static void main(String[] args) {
        Stack0<String> stack0 = new Stack0<>();
        stack0.push("a");
        stack0.push("b");
        stack0.push("c");
        stack0.push("d");
        System.out.println(stack0.pop()); //弹出栈顶元素
        System.out.println(stack0.size()); //栈中元素个数 3
        for (String s : stack0) {
            System.out.println(s); //遍历栈中元素
        }

        System.out.println("New LinkedListStack -------------");
        LinkedListStack<String> s = new LinkedListStack<>();
        s.push("A");
        s.push("B");
        s.push("C");
        s.push("D");
        s.push("E");
        System.out.println("第一次pop：" + s.pop());
        System.out.println("现在的第一个元素是(peak)" + s.peek());
        for (String value : s) {
            System.out.println(value);
        }

        System.out.println("New ArrayStack -------------");
        ArrayStack<String> s1 = new ArrayStack<>(4);
        System.out.println(s1.push("A"));
        System.out.println(s1.push("B"));
        System.out.println(s1.push("C"));
        System.out.println(s1.push("D"));
        System.out.println(s1.push("E"));
        System.out.println("第一次pop：" + s1.pop());
        System.out.println("现在的第一个元素是(peak)" + s1.peek());
        for (String value : s1) {
            System.out.println(value);
        }
    }
}
