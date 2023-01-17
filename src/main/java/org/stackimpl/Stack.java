package org.stackimpl;

public class Stack {

    private int index;
    private final int limit;
    private int[] stack;

    public Stack(int limit) {
        this.index = 0;
        this.limit = limit;
        this.stack = new int[] {};
    }

    public Stack() {
        this.index = 0;
        this.limit = Integer.MAX_VALUE;
        this.stack = new int[] {};
    }

    public int pop() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Stack is empty.");
        }
        int[] tmp = new int[--index];
        int value = stack[0];
        for (int i = 0; i < index; i++) {
            if (i + 1 == index) {
                break;
            } else {
                tmp[i] = stack[i + 1];
            }
        }
        this.stack = tmp;
        return value;
    }

    public void push(int value) {
        if (index == limit + 1) {
            throw new ArrayIndexOutOfBoundsException("Stack is full. Limit is: " + limit);
        }
        int[] tmp = new int[++index];
        tmp[0] = value;
        for (int i = 0; i < index; i++) {
            if (i + 1 == index) {
                break;
            } else {
                tmp[i + 1] = stack[i];
            }
        }
        this.stack = tmp;
    }

    public int size() {
        return this.index;
    }

    public boolean isEmpty() {
        return this.index == 0;
    }

}
