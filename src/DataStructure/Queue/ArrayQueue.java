package DataStructure.Queue;

import java.util.Iterator;

public class ArrayQueue<T> implements Iterable<T>{

    private final T[] array;
    private int head = 0;
    private int tail = 0;

    @SuppressWarnings("all")
    public ArrayQueue(int capacity) {
        array = (T[]) new Object[capacity + 1];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return (tail + 1) % array.length == head;
    }

    @SuppressWarnings("UnusedReturnValue")
    public boolean offer(T value) {
        if (this.isFull()) {
            return false;
        }
        array[tail] = value;
        tail = (tail + 1) % array.length;
        return true;
    }
    public T poll() {
        if (this.isEmpty()) {
            return null;
        }
        T headValue = array[head];
        array[head] = null;
        head = (head + 1) % array.length;
        return headValue;
    }
     public T peek() {
         if (this.isEmpty()) {
             return null;
         }
         return array[head];
     }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int p = head;
            @Override
            public boolean hasNext() {
                return tail != p;
            }

            @Override
            public T next() {
                T value = array[p];
                p = (p + 1) % array.length;
                return value;
            }
        };
    }
}
