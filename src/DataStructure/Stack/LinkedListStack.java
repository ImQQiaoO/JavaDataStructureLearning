package DataStructure.Stack;

import java.util.Iterator;

public class LinkedListStack<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> p = head.next;
            int n = 0;

            @Override
            public boolean hasNext() {
                return n < N;
            }

            @Override
            public T next() {
                n++;
                T currValue = p.item;
                p = p.next;
                return currValue;
            }
        };
    }

    //链表实现栈
    private static class Node<T> {
        public T item;
        public Node<T> next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }

    private final Node<T> head;
    private int N;
    private final int capacity;

    public LinkedListStack() {
        this.head = new Node<>(null, null);
        this.N = 0;
        this.capacity = Integer.MAX_VALUE;
    }

    public LinkedListStack(int capacity) {
        this.head = new Node<>(null, null);
        this.N = 0;
        this.capacity = capacity;
    }

    public boolean isFull() {
        return N == capacity;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean push(T value) {
        if (this.isFull()) {
            return false;
        }
        Node<T> newNode = new Node<>(value, null);
        newNode.next = head.next;
        head.next = newNode;
        N++;
        return true;
    }

    public T pop() {
        if (this.isEmpty()) {
            return null;
        }
        T value = head.next.item;
        head.next = head.next.next;
        N--;
        return value;
    }

    public T peek() {
        if (this.isEmpty()) {
            return null;
        }
        return head.next.item;
    }


}
