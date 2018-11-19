package backtracking_LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class SubSets_90 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Set<List<Integer>> tempresult = new HashSet<List<Integer>>();
		subSetsWithDupCore(0, nums, tempresult, new ArrayList<>());
		result.addAll(tempresult);		
		return result;
	}
	public void subSetsWithDupCore(int index, int[] nums, Set<List<Integer>> tempresult, List<Integer> temp) {
		tempresult.add(new ArrayList<>(temp));
		for(int i=index; i<nums.length; i++) {
			temp.add(nums[i]);
			subSetsWithDupCore(i+1, nums, tempresult, temp);
			temp.remove(temp.size()-1);
		}
	}
	public static void main(String[] args) {
		int[] nums = {1,2,2};
		List<List<Integer>> result = new SubSets_90().subsetsWithDup(nums);
		System.out.println(result);
	}
}
