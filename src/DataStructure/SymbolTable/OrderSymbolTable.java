package DataStructure.SymbolTable;

import java.util.Iterator;

public class OrderSymbolTable<K extends Comparable<K>, V> implements Iterable<K> {

    @Override
    public Iterator<K> iterator() {
        return new SymbolTableIterator();
    }

    private class SymbolTableIterator implements Iterator<K> {
        private Node<K, V> cur = dummyHead.next;

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public K next() {
            K key = cur.key;
            cur = cur.next;
            return key;
        }
    }

    private class Node<K, V> {
        public K key;
        public V value;
        public Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node<K, V> dummyHead;
    private int N;

    public OrderSymbolTable() {
        this.dummyHead = new Node<>(null, null, null);
        this.N = 0;
    }

    public int size() {
        return N;
    }


    //~~WRONG!!!!~~  Now, it is right!!
    public V put(K key, V value) {
        //有序符号表的put方法
        Node<K, V> currNode = dummyHead;
        Node<K, V> prevNode = dummyHead;
        while (currNode.next != null) {
            currNode = currNode.next;
            if (currNode.key.compareTo(key) > 0) { //currNode.key > key
                Node<K, V> newNode = new Node<>(key, value, null);
                newNode.next = prevNode.next;
                prevNode.next = newNode;
                N++;
                return null;
            } else if (currNode.key.equals(key)) {
                V oldValue = currNode.value;
                currNode.value = value;
                return oldValue;
            }
            prevNode = prevNode.next;
        }
        currNode.next = new Node<>(key, value, null);
        N++;
        return null;
    }

    public V put1(K key, V value) {
        //有序符号表的put方法
        Node<K, V> currNode = dummyHead;
        while (currNode.next != null) {
            if (currNode.next.key.compareTo(key) > 0) {
                Node<K, V> newNode = new Node<>(key, value, null);
                newNode.next = currNode.next;
                currNode.next = newNode;
                N++;
                return null;
            } else if (currNode.next.key.equals(key)) {
                V oldValue = currNode.next.value;
                currNode.next.value = value;
                return oldValue;
            }
            currNode = currNode.next;
        }
        currNode.next = new Node<>(key, value, null);
        N++;
        return null;
    }

    public V get(K key) {
        Node<K, V> cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

    public V delete(K k) {
        Node<K, V> prevNode = dummyHead;
        Node<K, V> currNode = dummyHead;
        while (currNode.next != null) {
            currNode = currNode.next;
            if (currNode.key.equals(k)) {
                V oldValue = currNode.value;
                prevNode.next = currNode.next;
                N--;
                return oldValue;
            }
            prevNode = prevNode.next;
        }
        return null;
    }

}
