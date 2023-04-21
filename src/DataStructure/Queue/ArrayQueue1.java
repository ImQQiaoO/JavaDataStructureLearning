package DataStructure.Queue;

import java.util.Iterator;

public class ArrayQueue1<T> implements Iterable<T>{ //这样写的好处：可以多存一个元素，不用浪费空间
    private final T[] array;
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    @SuppressWarnings("all")
    public ArrayQueue1(int size) {
        array = (T[]) new Object[size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    public boolean offer(T t) {
        if (isFull()) {
            return false;
        }
        array[tail] = t;
        tail = (tail + 1) % array.length;
        size++;
        return true;
    }

    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T currValue = array[head];
        array[head] = null;
        head = (head + 1) % array.length;
        size--;
        return currValue;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return array[head];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int p = 0;
            int count;
            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public T next() {
                T t = array[p];
                p = (p + 1) % array.length;
                count++;
                return t;
            }
        };
    }
}
