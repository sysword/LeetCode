package Dynamic_programming_LeetCode;

import java.util.Stack;

public class MaximalRectangle_85 {
	public int maximalRectangle(char[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length ==0) {
			return 0;
		}
		int[][] hight = new int[matrix.length][matrix[0].length];
		for(int i=0; i < matrix.length; i++) {
			for(int j=0; j < matrix[0].length; j++) {
				if(matrix[i][j] == '1') {
					hight[i][j] = i==0 ? 1 : hight[i-1][j] + 1;
				}else {
					hight[i][j] = 0;
				}
			}
		}
		int result = 0;
		for(int i=0; i < hight.length; i++) {
			int temp = largestRectangleArea(hight[i]);
			result = result >= temp ? result : temp;
		}
		
        return result;
    }
	public int largestRectangleArea(int[] heights) {
        if(heights==null||heights.length==0)
            return 0;
        int res=0;
        Stack<Integer> stack=new Stack<Integer>();
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty()&&heights[i]<=heights[stack.peek()]){
                int cur=stack.pop();
                int left=stack.isEmpty()?-1:stack.peek();
                res=Math.max(res,(i-left-1)*heights[cur]);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int cur=stack.pop();
            int left=stack.isEmpty()?-1:stack.peek();
            res=Math.max(res,(heights.length-left-1)*heights[cur]);
        }
        return res;
    }

}
