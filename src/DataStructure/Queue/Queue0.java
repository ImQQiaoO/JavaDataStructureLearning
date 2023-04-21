package DataStructure.Queue;

import java.util.Iterator;

public class Queue0<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return new queueIterator();
    } //FIFO

    private class queueIterator implements Iterator<T> {
        private Node current = head;
        @Override
        public boolean hasNext() {
            return current != null;
        }
        @Override
        public T next() {
            T data = current.data;
            current = current.next;
            return data;
        }
    }
    private class Node {
        T data;
        Node next;
        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    public Queue0() {
        head = null;
        tail = null;
        size = 0;
    }
    public void enqueue(T data) {
        if (head == null) {
            head = new Node(data, null);
            tail = head;
        } else {
            tail.next = new Node(data, null);
            tail = tail.next;
        }
        size++;
    }
    public T dequeue() {
        if (head == null) {
            return null;
        }
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }
//    public T peek() {
//        if (head == null) {
//            return null;
//        }
//        return head.data;
//    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }


}
