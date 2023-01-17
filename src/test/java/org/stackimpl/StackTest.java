package org.stackimpl;

public class StackTest {

    public static void main(String[] args) {
        testPushWithoutLimit();
        testPushWithLimit();
        testStackIsEmpty();
    }

    private static void testPushWithoutLimit() {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(40);
        assert stack.size() == 3;
        assert stack.pop() == 10;
        assert stack.size() == 2;
    }

    private static void testPushWithLimit() {
        Stack stack = new Stack(4);
        stack.push(20);
        stack.push(10);
        stack.push(50);
        assert stack.size() == 3;
        stack.push(50);
        assert stack.pop() == 20;
        stack.push(70);
        try {
            stack.push(100);
        } catch (ArrayIndexOutOfBoundsException e) {
            assert e.getMessage().equals("Stack is full. Limit is: 4");
        }
        assert stack.size() == 4;
    }

    private static void testStackIsEmpty() {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        assert stack.size() == 2;
        stack.pop();
        stack.pop();
        try {
            stack.pop();
        } catch (ArrayIndexOutOfBoundsException e) {
            assert e.getMessage().equals("Stack is empty.");
        }
        assert stack.size() == 0;
        assert stack.isEmpty();
    }

}
