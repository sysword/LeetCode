package Dynamic_programming_LeetCode;

import java.util.Arrays;

public class Coin_Change_322 {
    public static int coinChange(int[] coins, int amount) {
    	if(amount == 0) {
    		return 0;
    	}
    	int[] dp = new int[amount+1];
    	for(int i=0; i<=amount; i++) {
    		dp[i] = -1;
    	}
    	dp[0] = 0;
    	for(int i=1; i<=amount; i++) { //循环金额次
    		for(int j=0; j<coins.length; j++) { //尝试在当前金额下，如果使用当前coins[j]面额的钞票最少需要多少张
    			if((i - coins[j] >= 0) && (dp[i - coins[j]] != -1)) { //可以使用当前硬币，并且使用了当前硬币的情况下，剩余金额有解
    				if((dp[i] == -1)||(dp[i - coins[j]] + 1)<dp[i]) { //如果是第一次有解，或者当前解比之前的小，更新
    					dp[i] = dp[i - coins[j]] + 1;    					
    				}
    			}
    		}
    	}
    	System.out.println(Arrays.toString(dp));
        return dp[amount];
    }
    public static void main(String[] args) {
		int[] coins = {1,2,5};
		coinChange(coins, 11);
	}
}
