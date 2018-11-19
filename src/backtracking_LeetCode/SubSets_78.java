package backtracking_LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SubSets_78 {
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null || nums.length < 1) {
			return result;
		}
		ArrayList<Integer> temp = new ArrayList<>();
		subSetsCore(0, nums, result, temp);
		return result;
	}
	

	public void subSetsCore(int index, int[] nums, List<List<Integer>> result,ArrayList<Integer> temp) {
		result.add(new ArrayList<>(temp));
		for(int i=index; i<nums.length; i++) {
			temp.add(nums[i]);
			subSetsCore(i+1, nums, result, temp);
			temp.remove(temp.size()-1);
		}
	}
	
	/**
	 * 需要事先将空集push进result中
	 * 1.将数组中当前index位置上的数加入temp，得到一个新的子集
	 * 2.将temp放入result中
	 * 3.继续下一个位置上的递归
	 * 4.将当前位置放入的数弹出，
	 * 5.继续下一次递归
	 */
	public void subSetsCore2(int index, int[] nums, List<List<Integer>> result,ArrayList<Integer> temp) {
		if(index >= nums.length) {
			return;
		}
		temp.add(nums[index]);
		result.add(new ArrayList<>(temp));
		subSetsCore2(index + 1, nums, result, temp);
		temp.remove(temp.size()-1);
		subSetsCore2(index + 1, nums, result, temp);
	}
	
	public List<List<Integer>> subSetsCore3(int[] nums){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int all_set = 1 << nums.length;
		for(int i=0; i<all_set; i++) {
			List<Integer> temp = new ArrayList<>();
			for(int j=0; j<nums.length; j++) {
				if((i & (1 << j))!= 0) {
					temp.add(nums[j]);
				}
			}
			result.add(temp);
		}
		return result;
	}
}
