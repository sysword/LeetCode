package backtracking_LeetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis_22 {
	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n < 1) {
        	return result;
        }
        generateParenthesisCore("", n, n, result);
        return result;
    }
	public void generateParenthesisCore(String str, int left, int right, List<String> result) {
		if(left == 0 && right ==0) {
			result.add(str.toString());
			return ;
		}
		if(left > 0) {
			generateParenthesisCore(str+"(", left-1, right, result);
		}
		if(right > 0 && right > left) {
			generateParenthesisCore(str+")", left, right-1, result);
		}
	}
}
