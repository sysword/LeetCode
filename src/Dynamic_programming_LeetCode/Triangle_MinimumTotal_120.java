package Dynamic_programming_LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Triangle_MinimumTotal_120 {
    public static int minimumTotal(List<List<Integer>> triangle) {
    	if(triangle == null || triangle.size() == 0) {
    		return 0;
    	}
    	if(triangle.size() == 1) {
    		return triangle.get(0).get(0);
    	}
    	int size = triangle.size();
    	int[][] minimun_total = new int[triangle.size()][];
    	for(int i=0; i<triangle.size(); i++) {
    		minimun_total[i] = new int[triangle.get(i).size()];
    		for(int j=0; j<minimun_total[i].length; j++) {
    			if(i != size-1) {
    				minimun_total[i][j] = 0;
    			}else {
    				minimun_total[i][j] = triangle.get(i).get(j);
				}
    		}
    	}

    	for(int i=size-2; i>=0; i--) {
    		int temp_size = triangle.get(i).size();
    		for(int j=0; j<temp_size; j++) {
    			int tri_cur = triangle.get(i).get(j);
    			minimun_total[i][j] = Math.min(tri_cur + minimun_total[i+1][j],tri_cur + minimun_total[i+1][j+1]);
    		}
    	}
        return minimun_total[0][0];
    }
    public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> row1 = new ArrayList<>();
		List<Integer> row2 = new ArrayList<>();
		List<Integer> row3 = new ArrayList<>();
		List<Integer> row4 = new ArrayList<>();
		row1.add(2);
		row2.add(3);
		row2.add(4);
		row3.add(6);
		row3.add(5);
		row3.add(7);
		row4.add(4);
		row4.add(1);
		row4.add(8);
		row4.add(3);
		triangle.add(row1);
		triangle.add(row2);
		triangle.add(row3);
		triangle.add(row4);
		int result = minimumTotal(triangle);
		System.out.println(result);
	}
}
