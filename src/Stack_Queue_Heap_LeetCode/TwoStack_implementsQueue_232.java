package Stack_Queue_Heap_LeetCode;

import java.util.Stack;

public class TwoStack_implementsQueue_232 {
	
	private Stack<Integer> pushStack ;
	private Stack<Integer> popStack;
	
	public TwoStack_implementsQueue_232() {
		this.pushStack = new Stack<>();
		this.popStack = new Stack<>();
	}
	
	/** Push element x to the back of queue. */
    public void push(int x) {
    	pushStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(popStack.isEmpty()) {
        	while(!(pushStack.isEmpty())) {
        		popStack.push(pushStack.pop());
        	}
        }
        return popStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
    	if(popStack.isEmpty()) {
        	while(!(pushStack.isEmpty())) {
        		popStack.push(pushStack.pop());
        	}
        }
        return popStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
	
}
