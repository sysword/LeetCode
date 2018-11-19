package HashMap_String_LeetCode;

public class Minimum_Window_Substring_76 {
    public String minWindow(String s, String t) {
		//防止出现空指针异常
    	if(s == null || t == null) {
			return "";
		}
		
		String result = "";
		//指向当前可以移动到的最后位置
		int s_from_index = 0;
		//判断有没有成功过，只要成功过一次flag就变成true，如果到最后还是false，说明不包含。
        boolean flag = false;
        //存储到i位置时，从begin到i窗口中每个字符出现的次数
		int[] s_char_nums = new int[128];
		//记录t中字符出现的次数
		int[] t_char_nums = new int[128];
		for(int i=0; i<t.length(); i++) {
			t_char_nums[t.charAt(i)]++;
		}
		
		for(int i=0; i<s.length(); i++) {
			char temp = s.charAt(i);
			//判断此字符是否在t中出现过
			if(t_char_nums[temp] > 0) {
				//如果出现过，负责记录当前窗口中字符出现次数的s_char_nums数组对应位置上加一
				s_char_nums[temp]++;
				//更新s_from_index
				//t_char_nums[s.charAt(s_from_index)] <=0 当前字符在t中没有出现过
				//s_char_nums[s.charAt(s_from_index)] > t_char_nums[s.charAt(s_from_index)] 当前字符在窗口中出现过的次数超过了t中此字符出现过的数目
				while(t_char_nums[s.charAt(s_from_index)] <=0 || s_char_nums[s.charAt(s_from_index)] > t_char_nums[s.charAt(s_from_index)]) {
					//判断，如果是因为第二种情况进入的本次循环
					if(s_char_nums[s.charAt(s_from_index)] > 0) {
						s_char_nums[s.charAt(s_from_index)]--;
					}
					//s_from_index往后移一个
					s_from_index++;
				}
			}
			//如果当前窗口满足要求，判断是不是要更新result
			if(is_window_ok(s_char_nums, t_char_nums)) {
				int new_window_length = i - s_from_index + 1;
				//进入到此处说明有满足要求的窗口了，flag变为true
				if(result == "" || new_window_length < result.length()) {
					result = s.substring(s_from_index, i+1);
				}
			}
		}
		return result;
        
    }
	//判断窗口是否满足要求的函数
	public boolean is_window_ok(int[] s_char_nums, int[] t_char_nums) {
		for(int i=0; i<t_char_nums.length; i++) {
			if(t_char_nums[i] > s_char_nums[i]) {
				return false;
			}
		}
		return true;
	}
}