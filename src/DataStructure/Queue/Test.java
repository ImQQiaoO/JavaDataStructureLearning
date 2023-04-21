package DataStructure.Queue;

public class Test {
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        Queue0<Integer> q = new Queue0<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println("------------");
        for (Integer i : q) {
            System.out.println(i);
        }
        System.out.println("剩余的元素个数是：" + q.size());

        System.out.println("------------");

        LinkedListQueue<String> q2 = new LinkedListQueue<>();
        System.out.println("Empty: " + q2.isEmpty());
        q2.offer("A");
        q2.offer("B");
        q2.offer("C");
        q2.offer("D");
        for (String s : q2) {
            System.out.println(s);
        }
        System.out.println("剩余的元素个数是：" + q2.size());
        System.out.println("此时，队列中的首个元素是" + q2.peek());
        System.out.println("1. poll " + q2.poll()); // A
        System.out.println("2. poll " + q2.poll());
        System.out.println("3. poll " + q2.poll());
        System.out.println("4. poll " + q2.poll());
        System.out.println("剩余的元素个数是：" + q2.size());
        System.out.println("此时，队列中的首个元素是" + q2.peek());
        System.out.println("测试是否为满/添加成功----------------------------------");
        LinkedListQueue<String> q3 = new LinkedListQueue<>(3);
        System.out.println(q3.offer("A"));
        System.out.println(q3.offer("B"));
        System.out.println(q3.offer("C"));
        System.out.println("此时，队列中的首个元素是" + q3.peek());
        System.out.println("此时，队列是否为满：" + q3.isFull());
        System.out.println(q3.offer("D"));
        System.out.println("此时，队列中的个数是" + q3.size());
        for (String s : q3) {
            System.out.print(s + " ");
        }
        System.out.println();

        System.out.println("ArrayQueue +++++++++++++++++++++");
        ArrayQueue<String> aq = new ArrayQueue<>(10);
        System.out.println("Empty: " + aq.isEmpty());
        aq.offer("A");
        aq.offer("B");
        aq.offer("C");
        aq.offer("D");
        for (String s : aq) {
            System.out.println(s);
        }
//        System.out.println("剩余的元素个数是：" + aq.size());
        System.out.println("此时，队列中的首个元素是" + aq.peek());
        System.out.println("1. poll " + aq.poll()); // A
        System.out.println("2. poll " + aq.poll());
        System.out.println("3. poll " + aq.poll());
        System.out.println("4. poll " + aq.poll());

        System.out.println("ArrayQueue1 +++++++++++++++++++++");
        ArrayQueue1<String> aq1 = new ArrayQueue1<>(3);
        System.out.println("Empty: " + aq1.isEmpty());
        aq1.offer("A");
        aq1.offer("B");
        aq1.offer("C");
        aq1.offer("D");
        for (String s : aq1) {
            System.out.println(s);
        }
        System.out.println("1. poll " + aq1.poll()); // A
        System.out.println("2. poll " + aq1.poll());
        System.out.println("3. poll " + aq1.poll());
        System.out.println("4. poll " + aq1.poll());
    }
}
