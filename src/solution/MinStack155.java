package solution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author linglifan
 * @date 2022/09/24 15:27
 */
public class MinStack155 {

    Deque<Integer> stack1;
    Deque<Integer> minStack;
    public MinStack155() {
        stack1 = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack1.push(val);
        minStack.push(Math.min(minStack.peek(),val));
    }

    public void pop() {
        stack1.pop();
        minStack.pop();
    }


    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
