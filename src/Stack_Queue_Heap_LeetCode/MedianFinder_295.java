package Stack_Queue_Heap_LeetCode;

import java.util.PriorityQueue;

public class MedianFinder_295 {
	
	PriorityQueue<Integer> small_root_heap ;
	PriorityQueue<Integer> big_root_heap;
	
	public MedianFinder_295() {
		this.small_root_heap = new PriorityQueue<>((Integer frist,Integer second) -> frist - second);
		this.big_root_heap = new PriorityQueue<>((Integer first, Integer second) -> second - first);
	}
	
	public void addNum(int num) {
		if(small_root_heap.isEmpty()) {
			small_root_heap.add(num);
		}else if(small_root_heap.size() == big_root_heap.size()) {
        	if(num >= small_root_heap.peek()) {
        		small_root_heap.add(num);
        	}else {
        		big_root_heap.add(num);
			}
        }else if(small_root_heap.size() > big_root_heap.size()) {
        	if(num <= small_root_heap.peek()) {
        		big_root_heap.add(num);
        	}else {
        		big_root_heap.add(small_root_heap.poll());
        		small_root_heap.add(num);
			}
        }else if(small_root_heap.size() < big_root_heap.size()){
			if(num >= big_root_heap.peek()) {
				small_root_heap.add(num);
			}else {
				small_root_heap.add(big_root_heap.poll());
				big_root_heap.add(num);
			}
		}
    }
    
    public double findMedian() {
    	if(small_root_heap.size() == 0 && big_root_heap.size() == 0) {
    		return -10000000000000000.0;
    	}
    	if(small_root_heap.size() == big_root_heap.size()) {
    		return small_root_heap.peek()/2.0 + big_root_heap.peek()/2.0;
    	}else {
			return small_root_heap.size() > big_root_heap.size() ? small_root_heap.peek() : big_root_heap.peek();
		}
    }
}
