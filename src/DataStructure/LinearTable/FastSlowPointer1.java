package DataStructure.LinearTable;

public class FastSlowPointer1 {
    private static class Node<T> {
        public T item;
        public Node next;

        public Node(T item) {
            this.item = item;
        }
    }

    public static void main(String[] args) {
        //快慢指针确定单向链表是否有环 如果链表有环，快指针一定会追上慢指针
        //
        //1.创建节点
        Node<String> node1 = new Node<>("A");
        Node<String> node2 = new Node<>("B");
        Node<String> node3 = new Node<>("C");
        Node<String> node4 = new Node<>("D");
        Node<String> node5 = new Node<>("E");
        Node<String> node6 = new Node<>("F");
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = null;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3; //构成环
        //2.创建快慢指针
        Node<String> fast = node1;
        Node<String> slow = node1;
        Node<String> pre = null;
        //3.快指针走两步，慢指针走一步
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;     //记录慢指针的前一个节点
            slow = slow.next;
            if (fast == slow) {
                System.out.println("链表有环");
                break;
            }
        }
    }
}
