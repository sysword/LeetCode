package Dynamic_programming_LeetCode;

public class Maximum_Subarray_53 {
    public int maxSubArray(int[] nums) {
    	if(nums == null || nums.length == 0) {
    		return 0;
    	}
    	
    	int[] dp = new int[nums.length];
    	dp[0] = nums[0];
    	int result = dp[0];
    	for(int i=1; i<nums.length; i++) {
    		dp[i] = Math.max(dp[i] + nums[i], nums[i]);
    		result = Math.max(dp[i], result);
    	}
    	
        return result;
    }
}
