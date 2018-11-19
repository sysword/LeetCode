package Dynamic_programming_LeetCode;

public class ClimbStairs_70 {
	public int climbStairs(int n) {
        if(n <= 2) {
        	return n;
        }
        int F1 = 1;
        int F2 = 2;
        int FN = 0;
        for(int i=3; i<=n; i++) {
        	FN = F1 + F2;
        	F1 = F2;
        	F2 = FN;
        }
        return FN;
    }
}
