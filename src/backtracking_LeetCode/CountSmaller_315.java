package backtracking_LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CountSmaller_315 {
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> result = new ArrayList<>();
		if(nums == null || nums.length < 2) {
			return result;
		}
		Pair[] pairs = new Pair[nums.length];
		for(int i=0; i<nums.length; i++) {
			pairs[i] = new Pair(nums[i], i);
			result.add(0);
		}
		merge_sort(pairs, 0, pairs.length-1,result);
		return result;
    }
	
	public void merge_sort(Pair[] pairs, int l, int r,List<Integer> result) {
		if( l == r) {
			return;
		}
		int mid = l + (r - l)/2;
		merge_sort(pairs, l, mid, result);
		merge_sort(pairs, mid + 1, r, result);
		merge(pairs, l, mid, r, result);
	}
	
	public void merge(Pair[] pairs, int l, int mid, int r,List<Integer> result) {
		Pair[] help = new Pair[r - l + 1];
		int p1 = l;
		int p2 = mid + 1;
		int i=0;
		while(p1 <= mid && p2 <= r) {
			if(pairs[p1].num <= pairs[p2].num) {
				int ori_index = pairs[p1].ori_index;
				int count = result.get(ori_index) + (p2 - mid -1);
				result.set(ori_index,count);
				help[i++] = pairs[p1++];
			}else {
				help[i++] = pairs[p2++];
			}
		}
		while(p1 <= mid) {
			int ori_index = pairs[p1].ori_index;
			int count = result.get(ori_index) + (p2 - mid -1);
			result.set(ori_index,count);
			help[i++] = pairs[p1++];
		}
		while(p2 <= r) {
			help[i++] = pairs[p2++];
		}
		for(int j=0; j<help.length; j++) {
			pairs[l + j] = help[j];
		}
	}
	class Pair{
		int num;
		int ori_index;
		public Pair(int num, int ori_index) {
			this.num = num;
			this.ori_index = ori_index;
		}
	}
	public static void main(String[] args) {
		CountSmaller_315 count = new CountSmaller_315();
		int[] nums = {5,2,6,1,5,6,7,3,54,7,8,4,0,2,34,76,6,4,3,8,9,2,6};
		List<Integer> result = count.countSmaller(nums);
		System.out.println(result);
	}
}
