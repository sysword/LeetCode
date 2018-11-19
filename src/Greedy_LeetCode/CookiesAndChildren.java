package Greedy_LeetCode;

import java.util.Arrays;

public class CookiesAndChildren {
	public int findContentChildren(int[] g, int[] s) {
		if(g==null||s==null||g.length==0||s.length==0) {
			return 0;
		}
		Arrays.sort(g);
		Arrays.sort(s);
		int children = 0;
		int cookies = 0;
		while(children < g.length && cookies < s.length) {
			if(g[children] < s[cookies]) {
				children++;
				cookies++;
			}
			cookies++;
		}
        return children;
    }
}
