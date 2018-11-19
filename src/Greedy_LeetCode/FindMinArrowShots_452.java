package Greedy_LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots_452 {
	class Pair{
		int first;
		int second;
		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
	public int findMinArrowShots(int[][] points) {
		if(points==null) {
			return 0;
		}
		if(points.length < 2) {
			return points.length;
		}
		Pair[] Pair_points = new Pair[points.length];
        for(int i=0; i<points.length; i++) {
        	Pair_points[i] = new Pair(points[i][0], points[i][1]);
        }
        Arrays.sort(Pair_points,new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return o1.first - o2.first;
			}
		});
        
        int start_index = Pair_points[0].first;
        int end_index = Pair_points[0].second;
        int count = 1;
        for(int i=1; i<Pair_points.length; i++) {
        	if(Pair_points[i].first >= start_index && Pair_points[i].first <= end_index) {
        		start_index = Pair_points[i].first;
        		end_index = end_index > Pair_points[i].second ? Pair_points[i].second : end_index;
        		continue;
        	}
        	start_index = Pair_points[i].first;
    		end_index = Pair_points[i].second;
        	count++;
        }
        return count;
    }
}
