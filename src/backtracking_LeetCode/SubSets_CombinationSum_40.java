package backtracking_LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSets_CombinationSum_40 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Set<List<Integer>> tempResult = new HashSet<List<Integer>>();
		combinationSum2Core(0, target, candidates, tempResult, new ArrayList<>(),result,0);
		return result;
	}

	public void combinationSum2Core(int index, int target, int[] candidates, Set<List<Integer>> tempResult,
			List<Integer> temp, List<List<Integer>> result, int tempSum) {
		if (tempSum == target) {
			if(!tempResult.contains(temp)) {
				tempResult.add(new ArrayList<>(temp));
				result.add(new ArrayList<>(temp));
			}
		} else if (tempSum > target) {
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if(candidates[i] <= target && (target - getSum(temp)) < candidates[i]) {
				break ;
			}
			temp.add(candidates[i]);
			tempSum = getSum(temp);
			combinationSum2Core(i + 1, target, candidates, tempResult, temp,result,tempSum);
			temp.remove(temp.size() - 1);
		}
	}

	public int getSum(List<Integer> temp) {
		if(temp == null) {
			return 0;
		}
		int result = 0;
		for (int i = 0; i < temp.size(); i++) {
			result += temp.get(i);
		}
		return result;
	}
}
