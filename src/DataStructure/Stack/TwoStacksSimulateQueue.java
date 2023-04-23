package DataStructure.Stack;

import java.util.Stack;

public class TwoStacksSimulateQueue {
    public static void main(String[] args) {
        TwoStacksSimulateQueue queue = new TwoStacksSimulateQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.pop());
        queue.push(5);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }

    Stack<Integer> s0;
    Stack<Integer> s1;

    public TwoStacksSimulateQueue() {
        s0 = new Stack<>();
        s1 = new Stack<>();
    }

    public void push(int x) {
        while (!s0.empty()) {
            s1.push(s0.pop());
        }
        s1.push(x);
    }

    public int pop() {
        while (s1.size() != 0) {
            s0.push(s1.pop());
        }
        return s0.pop();
    }

    public int peek() {
        while (s1.size() != 0) {
            s0.push(s1.pop());
        }
        return s0.peek();
    }

    public boolean empty() {
        return s0.empty() && s1.empty();
    }
}
