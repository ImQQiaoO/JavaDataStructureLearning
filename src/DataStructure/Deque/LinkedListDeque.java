package DataStructure.Deque;

import java.util.Iterator;

/**
 * 基于双向环形链表实现双端队列
 * <p>
 * 为什么使用环形？ 因为环形可以避免头尾节点的特殊处理，即可以充当头，也可以充当尾，节省一个哨兵
 *
 * @param <T>
 */
public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {

    static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        public Node(T value, Node<T> prev, Node<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private final Node<T> sentinel = new Node<>(null, null, null);
    private Node<T> tail = sentinel;
    private int N = 0;
    private int capacity = Integer.MAX_VALUE;

    public LinkedListDeque() {
        tail.next = sentinel;
        sentinel.prev = tail;
    }
    public LinkedListDeque(int capacity) {
        tail.next = sentinel;
        sentinel.prev = tail;
        this.capacity = capacity;
    }



    @Override
    public boolean offerFirst(T value) {
        if (this.isFull()) {
            return false;
        }
        Node<T> oldFirst = sentinel.next;
        Node<T> newNode = new Node<>(value, sentinel, oldFirst);
        sentinel.next = newNode;
        oldFirst.prev = newNode;
        N++;
        return true;
    }

    @Override
    public boolean offerLast(T value) {
        if (this.isFull()) {
            return false;
        }
        Node<T> oldLast = sentinel.prev;
        Node<T> newNode = new Node<>(value, sentinel.prev, sentinel);
        sentinel.prev = newNode;
        oldLast.next = newNode;
        N++;
        return true;
    }

    @Override
    public T pollFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<T> delNode = sentinel.next;
        Node<T> newFirst = delNode.next;
        sentinel.next = newFirst;
        newFirst.prev = sentinel;
        N--;
        return delNode.value;
    }

    @Override
    public T pollLast() {
        if (isEmpty()) {
            return null;
        }
        Node<T> delNode = sentinel.prev;
        Node<T> newLast = delNode.prev;
        sentinel.prev = newLast;
        newLast.next = sentinel;
        N--;
        return delNode.value;
    }

    @Override
    public T peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return sentinel.next.value;
    }

    @Override
    public T peekLast() {
        if (isEmpty()) {
            return null;
        }
        return sentinel.prev.value;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public boolean isFull() {
        return N == capacity;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> p = sentinel.next;

            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public T next() {
                T currValue = p.value;
                p = p.next;
                return currValue;
            }
        };
    }
}
