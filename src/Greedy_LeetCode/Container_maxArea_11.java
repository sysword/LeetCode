package Greedy_LeetCode;

public class Container_maxArea_11 {
	public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while(left < right){
            if(height[left] <= height[right]){
                int tempArea = (right - left) * height[left++];
                maxArea = maxArea >= tempArea ? maxArea : tempArea;
            }else{
                int tempArea = (right - left) * height[right--];
                maxArea = maxArea >= tempArea ? maxArea : tempArea;
            }
        }
        return maxArea;
    }
}
