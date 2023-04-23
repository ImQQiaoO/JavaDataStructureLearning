package DataStructure.Deque;

public class Test {
    public static void main(String[] args) {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>(5);
        lld.offerFirst(1);
        lld.offerFirst(2);
        lld.offerFirst(3);
        lld.offerLast(4);
        lld.offerLast(5);
        System.out.println(lld.offerLast(6)); //false
        for (Integer integer : lld) {   //3 2 1 4 5
            System.out.println(integer);
        }

        System.out.println("Test poll-------------------------");
        LinkedListDeque<Integer> dq0 = new LinkedListDeque<>(5);
        dq0.offerLast(1);
        dq0.offerLast(2);
        dq0.offerLast(3);
        dq0.offerLast(4);
        dq0.offerLast(5);

        System.out.println(dq0.pollFirst()); //1
        System.out.println(dq0.pollFirst()); //2
        System.out.println(dq0.pollLast()); //5
        System.out.println(dq0.pollLast()); //4
        System.out.println(dq0.pollLast()); //3
        System.out.println(dq0.pollLast()); //null
    }
}
