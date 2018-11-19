package Stack_Queue_Heap_LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthLargest_215 {
	public static int findKthLargest(int[] arr, int k) {
		PriorityQueue<Integer> small_root_heap = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 -o2;
			}
		});
		int index = 0;
		while(index < arr.length) {
			if(small_root_heap.size()<k) {
				small_root_heap.add(arr[index]);
			}else if(small_root_heap.peek() < arr[index]) {
				System.out.println(small_root_heap.poll());
				small_root_heap.add(arr[index]);
			}
			index++;
		}
		return small_root_heap.peek();
	}
	public static void main(String[] args) {
		int[] arr = {3,2,1,5,6,4};
		System.out.println(findKthLargest(arr, 2));
	}
}
