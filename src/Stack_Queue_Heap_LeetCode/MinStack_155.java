package Stack_Queue_Heap_LeetCode;

import java.util.Stack;

public class MinStack_155 {
	Stack<Integer> dataStack ;
	Stack<Integer> minStack ;
	
	public MinStack_155() {
		this.dataStack = new Stack<>();
		this.minStack = new Stack<>();
	}
	
	public void push(int x) {
		dataStack.push(x);
		if(minStack.isEmpty()) {
			minStack.push(x);
		}else if(x > minStack.peek()) {
			minStack.push(minStack.peek());			
		}else if(x <= minStack.peek()) {
			minStack.push(x);
		}
    }
    
    public void pop() {
        if(!(dataStack.isEmpty())) {
        	dataStack.pop();
        	minStack.pop();
        }
    }
    
    public int top() {
        return dataStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
	
}
