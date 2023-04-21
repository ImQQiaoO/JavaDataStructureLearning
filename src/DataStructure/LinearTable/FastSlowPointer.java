package DataStructure.LinearTable;

public class FastSlowPointer {
    private static class Node<T> {
        public T item;
        public Node next;

        public Node(T item) {
            this.item = item;
        }
    }

    public static void main(String[] args) {
        //快慢指针确定中间节点
        //如果链表长度为奇数，快指针走到尾节点时，慢指针刚好走到中间节点
        //如果链表长度为偶数，快指针走到尾节点时，慢指针刚好走到中间节点的后一个节点
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
        node6.next = null;
        //2.创建快慢指针
        Node<String> fast = node1;
        Node<String> slow = node1;
        Node<String> pre = null;
        //3.快指针走两步，慢指针走一步
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;     //记录慢指针的前一个节点
            slow = slow.next;
        }
        //5.输出链表的中间节点(慢指针)
        System.out.println("链表的中间节点为：" + slow.item);
        System.out.println(pre.item);

    }
}
