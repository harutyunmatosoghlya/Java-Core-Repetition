package brace;

import java.lang.reflect.Array;

public class Stack<T> {
    private T[] stack;
    private int tos;
    private final Class<T> clazz;

    public Stack(Class<T> clazz, int size) {
        this.clazz = clazz;
        this.stack = (T[]) Array.newInstance(clazz, size);
        this.tos = -1;
    }

    public void push(T item) {
        if (tos == stack.length - 1) {
            T[] newStack = (T[]) Array.newInstance(clazz, stack.length * 2);
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        stack[++tos] = item;
    }

    public T pop() {
        if (tos == -1) return null;
        return stack[tos--];
    }

    public boolean isEmpty() {
        return tos == -1;
    }
}