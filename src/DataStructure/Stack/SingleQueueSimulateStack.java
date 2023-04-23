package DataStructure.Stack;

public class SingleQueueSimulateStack {
    public static void main(String[] args) {
        SingleQueueSimulateStack stack = new SingleQueueSimulateStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.empty());
    }

    Queue queue;
    int size;

    public SingleQueueSimulateStack() {
        queue = new Queue();
        size = 0;
    }

    public void push(int x) { //这样入栈不行，没有考虑数字重复的情况

        queue.offer(x);
        size++;
        for (int i = 0; i < size - 1; i++) {
            queue.offer(queue.poll());
        }

    }

    public int pop() {
        size--;
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.size() == 0;
    }

    static class Queue {   //使用链表来实现队列
        //链表、单向、环形、带哨兵的方式实现队列
        private static class Node<T> {
            T value;
            Node<T> next;

            public Node(T value, Node<T> next) {
                this.value = value;
                this.next = next;
            }
        }

        private final Node head = new Node<>(null, null);
        private Node tail = head;
        private int N = 0;
        private int capacity = Integer.MAX_VALUE;

        public Queue() {
            tail.next = head;
        }

        public Queue(int capacity) {
            this.capacity = capacity;
            tail.next = head;
        }

        public boolean offer(int value) {
            if (this.isFull()) {
                return false;
            }
            Node added = new Node<>(value, head);
            tail.next = added;
            tail = added;
            N++;
            return true;
        }

        //获取队列头部的值，并且不移除
        public int poll() {
            Node outNode = head.next;
//        if (head.next == tail){ //这里这样写也行
//            tail = head;
//        }
            head.next = head.next.next;
            if (outNode == tail) {
                tail = head;
            }
            N--;
            return (int) outNode.value;
        }

        //获取队列头部的值，但是不移除
        public int peek() {
            return (int) head.next.value;
        }

        public boolean isEmpty() {
            return head == tail;
        }

        /**
         * 判断队列是否已满
         *
         * @return true:已满，false:未满
         */
        public boolean isFull() {
            return N == capacity;
        }

        public int size() {
            return N;
        }
    }
}


