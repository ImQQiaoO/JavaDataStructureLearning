package DataStructure.Stack;

import java.util.Iterator;
public class Stack0<T> implements Iterable<T>{
    //链表实现栈
    private final Node head;
    private int N;
    private class Node{
        public T item;
        public Node next;

        public Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
    }


    public Stack0(){
        this.head = new Node(null, null);
        this.N = 0;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }
    public void push(T item){
        //先进后出
        Node oldFirst = head.next;
        head.next = new Node(item, oldFirst);
        N++;
    }
    public T pop(){
        Node oldFirst = head.next;
        if (oldFirst == null){
            return null;
        }
        head.next = oldFirst.next;
        N--;
        return oldFirst.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }
    private class StackIterator implements Iterator<T>{
        private Node n;
        public StackIterator(){
            this.n = head;
        }
        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public T next() {
            n = n.next;
            return n.item;
        }
    }
}
