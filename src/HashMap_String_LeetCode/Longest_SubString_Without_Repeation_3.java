package HashMap_String_LeetCode;

import java.util.HashSet;

public class Longest_SubString_Without_Repeation_3 {
	public int lengthOfLongestSubstring(String s) {
		int maxLenth = 0;
		if(s == null || s.length() < 1) {
			return maxLenth;
		}
		HashSet<Character> set = new HashSet<>();
		int index = 0, pre_index = 0;
		while(index < s.length()) {
			if(!set.contains(s.charAt(index))){
				set.add(s.charAt(index++));
				maxLenth = Math.max(maxLenth, set.size());
			}else {
				set.remove(s.charAt(pre_index++));
			}
		}
		return maxLenth;
	}
}
