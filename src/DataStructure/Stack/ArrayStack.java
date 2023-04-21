package DataStructure.Stack;

import java.util.Iterator;

public class ArrayStack<T> implements Iterable<T>{
    private T[] array;
    private int top;

    /*
                数组实现栈示意图：
                底       顶
                0  1  2  3
         添加元素:a
         top指针:   ↑
     */
    @SuppressWarnings("all")
    public ArrayStack(int capacity) {
        array = (T[]) new Object[capacity];
        top = 0;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public boolean isFull() {
        return top == array.length;
    }

    public boolean push(T value) {
        if (isFull()) {
            return false;
        }
        array[top] = value; //array[top++] = value; 后++: 先做求索引的运算，然后+1
        top++;
        return true;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return array[top - 1];
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T outValue = array[top - 1];
        top--;
        return outValue;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int p = top - 1; //p = 0是错误的
            @Override
            public boolean hasNext() {
                return p >= 0;
            }

            @Override
            public T next() {
                T value = array[p];
                p--;
                return value;
            }
        };
    }
}
