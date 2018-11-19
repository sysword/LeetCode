package HashMap_String_LeetCode;


public class LongestPalindrome_409 {
	public int longestPalindrome(String s) {
        int result = 0;
        int[] character = new int[128];
        for(int i=0; i<s.length(); i++) {
        	character[s.charAt(i) - 'A'] ++;
        }
        boolean flag = false;
        for(int i=0; i<character.length; i++) {
        	if(character[i] != 0 && character[i] % 2 == 0) {
        		result+=character[i];
        	}else if(character[i] % 2 == 1) {
        		flag = true;
        		result+=character[i]-1;
        	}
        }
        return flag == true ? result+1 : result;
    }
}
