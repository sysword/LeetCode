package backtracking_LeetCode;

import java.util.ArrayList;
import java.util.List;



public class N_Queen_51_2 {
	public static int[] dx = {-1,0,1,1,1,0,-1,-1};
	public static int[] dy = {-1,-1,-1,0,1,1,1,0};
	
	public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        return result;
    }
	
	public void NQueensCore(int k, int n, List<List<String>> result,int[][] mark, List<String> location) {
	}
	
	public static  void putDownQueen(int x, int y, int[][] mark) {
		mark[x][y] = 1;
		for(int i=0; i<mark.length; i++) {
			for(int j=0; j<8; j++) {
				int new_x = x + i * dx[j];
				int new_y = y + i * dy[j];
				if(new_x >= 0 && new_x < mark.length && new_y >= 0 && new_y < mark[0].length) {
					mark[new_x][new_y] = 1;
				}
			}
		}
	}
	
	public int[][] copyArray(int[][] mark){
		int[][] result = new int[mark.length][mark[0].length];
		for(int i=0; i<mark.length; i++) {
			result[i] = mark[i].clone();
		}
		return result;
	}
	public static void main(String[] args) {
		N_Queen_51_2 queen = new N_Queen_51_2();
		
		List<List<String>> result = queen.solveNQueens(4);
		System.out.println(result);
	}

}
