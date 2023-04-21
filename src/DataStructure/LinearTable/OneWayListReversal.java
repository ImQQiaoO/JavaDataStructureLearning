package DataStructure.LinearTable;

public class OneWayListReversal {
    //单链表反转
    public static class Node {
        public int item;
        public Node next;

        public Node(int item) {
            this.item = item;
        }
    }

    public static void main(String[] args) {
        // 创建单链表
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
//        Node node4 = new Node(4);
//        Node node5 = new Node(5);

        head.next = node2;
        node2.next = node3;
        node3.next = null;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = null;


        Node newHead = reverse(head);
        while (newHead != null) { //迭代输出
            System.out.println(newHead.item);
            newHead = newHead.next;
        }
    }

    public static Node reverse0(Node currNode) { //迭代法
        Node preNode = null;
        Node nextNode = null;
        while (currNode != null) {
            //错误：此时head.next已经被改变，所以要先保存head.next
            nextNode = currNode.next; //保存head.next
            currNode.next = preNode; //改变head.next
            preNode = currNode; //preNode后移
            currNode = nextNode; //head后移
        }
        return preNode;
    }

    public static Node reverse(Node currNode) { //递归法
        if (currNode == null || currNode.next == null) {
            return currNode; //递归出口
        }
        Node preNode = reverse(currNode.next);  //递归
        currNode.next.next = currNode;  //改变指针指向
        currNode.next = null;   //改变指针指向
        return preNode;
    }
}
