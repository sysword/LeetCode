package Stack_Queue_Heap_LeetCode;

import java.util.Stack;

public class ValidStackPop_POJ {
	public static boolean rails(int[] yuan,int[] arr) {
		if(yuan==null||arr==null||yuan.length!=arr.length) {
			return false;
		}
		Stack<Integer> rail = new Stack<>();
		int index = 0;
		int yuanindex = 0;
		while(index < arr.length) {
			rail.push(yuan[yuanindex]);
			while(!(rail.isEmpty())&&rail.peek() == arr[index]) {
				rail.pop();
				index++;
			}
			yuanindex++;
		} 
		if(rail.isEmpty() && yuanindex == arr.length) {
			return true;
		}else {
			return false;
		}
	}
}
