package Greedy_LeetCode;


public class CanJump_55 {
	public static boolean canJump(int[] nums) {
		
		if(nums==null) {
			return true;
		}
		for(int i=0; i < nums.length; i++) {
			nums[i] += i + nums[i];
		}
		int max_length = 0;
		int jump = 0;
		while(jump < nums.length && jump < max_length && max_length < nums.length) {
			if(nums[jump] > max_length) {
				max_length = nums[jump];
			}
			jump++;
		}
		if(max_length >= nums.length) {
			return true;
		}
		
		return false;
	}
}
