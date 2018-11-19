package Greedy_LeetCode;


public class RemoveKDigits_402 {
	
	public static String removeKDigits(String num , int k) {
		
		if(num == null || k >= num.length()) {
			return "0";
		}
		StringBuffer result = new StringBuffer(num);
		int index = 0;
		int remove = 0;
		while(index < result.length()-1 && remove < k) {
			if(result.charAt(index) > result.charAt(index+1)) {
				result.deleteCharAt(index);
				remove++;
                if(index > 0){
                    index--;
                }
			}else {
				index++;
			}
		}
		while(index > 0 && remove < k) {
			if(result.charAt(index) >= result.charAt(index - 1) ) {
				result.deleteCharAt(index);
				remove++;
			}
            index--;
		}
		index = 0;
		String string = "0";
		while(index < result.length()) {
			if(result.charAt(index) != '0') {
				string =  result.substring(index, result.length());
                break;
			}else {
				index++;
			}
		}
		
		return string;
	}
}
