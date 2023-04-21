package DataStructure.LinearTable;

import java.util.Iterator;

public class LinkList<T> implements Iterable<T>{

    private class Node {     // 定义内部类Node
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
    private final Node head;  // 头结点
    private int N;  // 元素个数



    public LinkList() { // 构造函数
        // 初始化头结点 init head node
        this.head = new Node(null, null);
        // 初始化元素个数
        this.N = 0;
    }

    public void clear() {   // 将链表置为空表
        // 将头结点的next指向null
        this.head.next = null;
        // 元素个数置为0
        this.N = 0;
    }

    public int length() {   // 获取链表的长度
        return this.N;
    }

    public boolean isEmpty() {   // 判断链表是否为空表
        return this.N == 0;
    }

    public T get(int i) {
        // 通过循环，从头节点开始往后查找，找i次就能找到对应的元素
        Node n = head.next;
        for (int index = 0; index < i; index++) {
            n = n.next;
        }
        return n.item;
    }

    public void insert(T t) {
        //找到当前最后一个节点
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        //创建新节点，保存元素t
        Node newNode = new Node(t, null);
        //让当前最后一个节点指向新节点
        n.next = newNode;
        //元素的个数+1
        N++;
    }

    public void insert(int i, T t) {
        //找到i位置的前一个节点
        Node preNode = head;
        if (i > N){
            throw new RuntimeException("插入位置不合法");
        }
        for (int index = 0; index < i; index++) {
            preNode = preNode.next;
        }
        //找到i位置的节点
        Node currNode = preNode.next;
        //创建新节点,新节点要指向原来i位置的节点
        Node newNode = new Node(t, currNode);
        //让原来i位置的前一个节点指向新节点
        preNode.next = newNode;
        //元素个数+1
        N++;
    }

    public T remove(int i) { //删除指定i位置出的节点，并返回被删除的元素
        //找到i位置的前一个节点
        Node preNode = head;
        for (int index = 0; index < i; index++) {
            preNode = preNode.next;
        }
        //找到i位置的节点
        Node currtNode = preNode.next;
        //找到i位置的后一个节点
        Node nextNode = currtNode.next;
        //让i位置的前一个节点指向i位置的后一个节点
        preNode.next = nextNode;
        //元素个数-1
        N--;
        return currtNode.item;
    }

    public int indexOf(T t) { //查找元素t在链表中第一次出现的位置
        //从头节点开始往后查找
        Node n = head;
        int i = 0;
        while (n.next != null) {
            n = n.next;
            if (n.item.equals(t)) {
                return i;
            }
            i ++;
        }
        return -1;

    }
    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator<T>{
        private Node n;
        public LIterator(){
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
