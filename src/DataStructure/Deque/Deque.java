package DataStructure.Deque;

/**
 * 双端队列接口
 * @param <T>-队列中元素类型
 */
public interface Deque<T> {
    boolean offerFirst(T t);

    boolean offerLast(T t);

    T pollFirst();

    T pollLast();

    T peekFirst();

    T peekLast();

    boolean isEmpty();

    boolean isFull();
}
