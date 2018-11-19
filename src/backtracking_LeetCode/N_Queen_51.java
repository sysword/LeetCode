package backtracking_LeetCode;

import java.util.ArrayList;
import java.util.List;



public class N_Queen_51 {
	public static int[] dx = {-1,0,1,1,1,0,-1,-1};
	public static int[] dy = {-1,-1,-1,0,1,1,1,0};
	public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        int[][] mark = new int[n][n];
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		mark[i][j] = 0;
        	}
        }
        NQueensCore(0, n, result, mark,new ArrayList<String>());
        System.out.println("result return: " + result);
        return result;
    }
	
	public void NQueensCore(int k, int n, List<List<String>> result,int[][] mark, List<String> location) {
		if(k >= n) {
			result.add(new ArrayList<>(location));
			return;
		}
		StringBuilder temp = new StringBuilder();
		for(int i=0; i<n; i++) {
			if(mark[k][i] == 0) {
				int[][] save_copy = copyArray(mark);
				putDownQueen(k, i, mark);
				StringBuilder clone = new StringBuilder(temp.toString()+".");
				temp.append("Q");
				while(temp.length() < n) {
					temp.append(".");
				}
				location.add(temp.toString());
				NQueensCore(k+1, n, result, mark,location);
				location.remove(k);
				mark = save_copy;
				temp = clone;
			}else {
				temp.append(".");
			}
		}
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
		N_Queen_51 queen = new N_Queen_51();
		/*int[][] mark = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		putDownQueen(3, 3, mark);
		for(int i=0; i<mark.length; i++) {
			System.out.println(Arrays.toString(mark[i]));
		}*/
		
		List<List<String>> result = queen.solveNQueens(4);
		System.out.println(result);
	}

}
