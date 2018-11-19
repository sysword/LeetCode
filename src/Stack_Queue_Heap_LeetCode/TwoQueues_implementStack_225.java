package Stack_Queue_Heap_LeetCode;

import java.util.ArrayDeque;
import java.util.Queue;

public class TwoQueues_implementStack_225 {
	
	private Queue<Integer> dataQueue ;
	private Queue<Integer> tempQueue ;
	
	public TwoQueues_implementStack_225() {
		this.dataQueue = new ArrayDeque<>();
		this.tempQueue = new ArrayDeque<>();
	}
	public void push(int x) {
		tempQueue.add(x);
		while(!(dataQueue.isEmpty())) {
			tempQueue.add(dataQueue.poll());
		}
		Queue<Integer> temp = dataQueue;
		dataQueue = tempQueue;
		tempQueue = temp;
	}
	
	public int pop() {
		return dataQueue.poll();
	}
	
	public int top() {
		return dataQueue.peek();
	}
	public boolean isEmpty() {
		return dataQueue.isEmpty();
	}
	
}
