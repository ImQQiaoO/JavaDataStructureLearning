package DataStructure.SymbolTable;

import java.util.Iterator;

public class SymbolTable<K, V>  implements Iterable<K>{

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

    public SymbolTable() {
        this.dummyHead = new Node<>(null, null, null);
        this.N = 0;
    }

    public int size() {
        return N;
    }

    public V put(K key, V value) {
        Node<K, V> cur = dummyHead;
        while (cur.next != null) {
            cur = cur.next;
            if (cur.key.equals(key)) {
                V oldValue = cur.value;
                cur.value = value;
                return oldValue;
            }
        }
        cur.next = new Node<>(key, value, null);
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
