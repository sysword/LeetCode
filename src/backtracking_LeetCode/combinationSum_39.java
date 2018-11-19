package backtracking_LeetCode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum_39 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		combinationSum2Core(0, target, candidates, new ArrayList<>(),result,0);
		return result;
	}

	public void combinationSum2Core(int index, int target, int[] candidates,List<Integer> temp, List<List<Integer>> result, int tempSum) {
		if (tempSum == target) {
			result.add(new ArrayList<>(temp));
			return ;
		} else if (tempSum > target) {
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if((target - tempSum) < candidates[0]) {
				break ;
			}
			temp.add(candidates[i]);
			combinationSum2Core(i, target, candidates, temp,result,tempSum + candidates[i]);
			temp.remove(temp.size() - 1);
		}
	}
	public static void main(String[] args) {
		int[] can = {1,2};
		combinationSum_39 com = new combinationSum_39();
		List<List<Integer>> result = com.combinationSum2(can, 4);
		System.out.println(result);
	}
}

