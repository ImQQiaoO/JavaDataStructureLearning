package DataStructure.Queue;

import java.util.Iterator;

public class LinkedListQueue<T> implements Iterable<T> {   //使用链表来实现队列
    //链表、单向、环形、带哨兵的方式实现队列
    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private final Node<T> head = new Node<>(null, null);
    private Node<T> tail = head;
    private int N = 0;
    private int capacity = Integer.MAX_VALUE;

    public LinkedListQueue() {
        tail.next = head;
    }

    public LinkedListQueue(int capacity) {
        this.capacity = capacity;
        tail.next = head;
    }

    public boolean offer(T value) {
        if (this.isFull()) {
            return false;
        }
        Node<T> added = new Node<>(value, head);
        tail.next = added;
        tail = added;
        N++;
        return true;
    }

    //获取队列头部的值，并且不移除
    public T poll() {
        if (this.isEmpty()) {
            return null;
        }
        Node<T> outNode = head.next;
//        if (head.next == tail){ //这里这样写也行
//            tail = head;
//        }
        head.next = head.next.next;
        if (outNode == tail){
            tail = head;
        }
        N--;
        return outNode.value;
    }

    //获取队列头部的值，但是不移除
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return head.next.value;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * 判断队列是否已满
     * @return true:已满，false:未满
     */
    public boolean isFull() {
        return N == capacity;
    }

    public int size() {
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> p = head.next;

            @Override
            public boolean hasNext() {
                return p != head;
            }

            @Override
            public T next() {
                T value = p.value;
                p = p.next;
                return value;
            }
        };
    }

}
