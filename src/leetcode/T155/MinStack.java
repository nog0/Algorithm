package leetcode.T155;

import java.util.Stack;

public class MinStack {

    private final Stack<Integer> s;
    private final Stack<Integer> min_stack;

    public MinStack() {
        s = new Stack<>();
        min_stack = new Stack<>();
    }

    public void push(int value) {
        s.push(value);
        if(min_stack.empty()){
            min_stack.push(value);
            return;
        }
        if(value<=min_stack.peek()){
            min_stack.push(value);
        }
    }

    public void pop() {
        int p = s.pop();
        if(p<=min_stack.peek()){
            min_stack.pop();
        }
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }
}
