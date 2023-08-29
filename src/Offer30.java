import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Offer30 {
    Deque<Integer> inStack;
    Deque<Integer> minStack;
    public void  MinStack() {
        inStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();

    }

    public void push(int x) {
        inStack.push(x);
        if (minStack.isEmpty()){
            minStack.push(x);
            return;
        }
        if (x<minStack.peek()){
            minStack.push(x);
        }else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        inStack.pop();
        minStack.pop();
    }

    public int top() {
        return inStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
