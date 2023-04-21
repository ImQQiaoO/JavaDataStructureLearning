package DataStructure.LinearTable;

import java.util.Iterator;

public class DoubleLinkList<T> implements Iterable<T> { //双向链表
    private final Node head;  // 头结点
    private Node last;  // 尾结点

    private int N;  // 元素个数

    private class Node {     // 定义内部类Node
        public T item;
        public Node next;  // 指向下一个节点
        public Node prev; // 指向上一个节点

        public Node(T item, Node next, Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    public DoubleLinkList() { // 构造函数
        // 初始化头结点 init head node
        this.head = new Node(null, null, null);
        // 初始化尾结点 init last node
        this.last = null;
        // 让头结点的next指向尾结点
        this.head.next = last;
        // 初始化元素个数
        N = 0;
    }

    public void clear() {
        last = null;
        head.next = last;
        head.prev = null;
        head.item = null;
        N = 0;
    }

    public int length() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public T get(int n) {
        if (n < 0 || n >= N) {
            throw new RuntimeException("获取位置不合法");
        }
        Node curr = head.next;
        for (int i = 0; i < n; i++) {
            curr = curr.next;
        }
        return curr.item;
    }

    public void insert(T t) {
        if (last == null) {
            last = new Node(t, null, head);
            head.next = last;
        } else {
            Node oldLast = last;
            last = new Node(t, null, oldLast);
            oldLast.next = last;
        }
        N = N + 1;
    }

    public void insert(int n, T t) {
        if (n < 0 || n >= N + 1) {
            throw new RuntimeException("插入位置不合法");
        }
        Node prevNode = head;
        if (n == N) {
            insert(t);
        }else {
            for (int i = 0; i < n; i++) {
                prevNode = prevNode.next;
            }
            Node currNode = prevNode.next;
            Node newNode = new Node(t, currNode, prevNode);
            prevNode.next = newNode;
            currNode.prev = newNode;
            N = N + 1;
        }
    }

    public int indexOf(T t) { // 查找元素t在链表中的位置
        Node currNode = head.next;
        for (int i = 0; i < N; i++) {
            if (currNode.item.equals(t)) {
                return i;
            }
            currNode = currNode.next;
        }
        return -1;

    }

    public T remove(int n) {
        if (n < 0 || n >= N) {
            throw new RuntimeException("删除位置不合法");
        }
        Node currNode = head.next;
        for (int i = 0; i < n; i++) {  // 找到要删除的节点
            currNode = currNode.next; // currNode指向要删除的节点
        }
        if (n == N - 1) {
            last = currNode.prev;
            last.next = null;
        } else {
            Node prevNode = currNode.prev;
            Node nextNode = currNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        N = N - 1;
        return currNode.item;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("链表为空");
        }
        return head.next.item;
    }

    public T getLast() {
        if (isEmpty()) {
            throw new RuntimeException("链表为空");
        }
        return last.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }

    private class TIterator implements Iterator<T> {

        private Node node = head;
        private int cnt = 0;

        @Override
        public boolean hasNext() {
            return cnt != N;
        }

        @Override
        public T next() {
            cnt++;
            node = node.next;
            return node.item;
        }
    }

}
