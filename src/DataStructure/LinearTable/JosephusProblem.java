package DataStructure.LinearTable;

public class JosephusProblem {

    private static class Node<T> {
        public T item;
        public Node next;

        public Node(T item) {
            this.item = item;
        }
    }

    public static void main(String[] args) {
        //41个人围成一圈，从第一个人开始报数，报到3的人出列，然后从下一个人重新开始报数，报到3的人出列，直到所有人都出列
        Node<Integer> first = null;
        Node<Integer> prev = null;
        for (int i = 1; i < 42; i++) {
            if (i == 1) {
                first = new Node<>(i);  //创建头节点
                prev = first;   //记录头节点
                continue;   //跳过本次循环
            }
            Node<Integer> newNode = new Node<>(i);  //创建新节点
            prev.next = newNode;    //将新节点添加到链表中
            prev = newNode;    //记录新节点
            if (i == 41) {
                prev.next = first;  //构成环
            }
        }
        int cnt = 0;
        Node<Integer> n = first;
        //记录当前节点的上一个节点
        Node<Integer> before = null;
        while (n.next != n) {   //当链表只剩下一个节点时，退出循环
            cnt++;
            if (cnt == 3) {     //报数为3时，删除当前节点
                before.next = n.next;   //删除当前节点
                System.out.println(n.item);   //打印删除的节点
                cnt = 0;
            } else {
                before = n;    //记录当前节点的上一个节点
            }
            n = n.next;    //指针后移
        }
//        System.out.println(n.item); //打印最后一个元素
//        while (n.next != n) {
//            cnt++;
//            if (cnt == 3) {
//                before.next = n.next;
//                System.out.println(n.item);
//                cnt = 0;
//            } else {
//                before = n;
//            }
//            n = n.next;
//        }
        System.out.println(n.item);
    }
}
