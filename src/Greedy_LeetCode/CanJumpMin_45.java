package Greedy_LeetCode;

public class CanJumpMin_45 {
	public static int jump(int[] nums) {
		if(nums == null || nums.length < 2) {
			return 0;
		}
		int pre_max_index = 0;
		int current_max_index = 0;
		int jump_min = 0;
		for(int i = 0; i < nums.length; i++) {
			if(i > current_max_index) {
				jump_min++;
				current_max_index = pre_max_index;
			}
			if(pre_max_index < nums[i] + i) {
				pre_max_index = nums[i] + i;
			}
		}
		return jump_min;
	}
}
