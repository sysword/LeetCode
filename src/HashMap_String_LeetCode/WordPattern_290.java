package HashMap_String_LeetCode;

import java.util.HashMap;

public class WordPattern_290 {
	public boolean wordPattern(String pattern, String str) {
        boolean flag = true;
        if(pattern == null && str == null) {
        	return true;
        }
        if(pattern == null || str == null) {
        	return false;
        }
        String[] strArray = str.split(" ");
        HashMap<Character, String> pattern_word_map = new HashMap<>();
        HashMap<String, Character> word_pattern_map = new HashMap<>();
        if(pattern.length() == strArray.length) {
        	for(int i=0; i<pattern.length(); i++) {
        		String temp_word = pattern_word_map.get(pattern.charAt(i));
        		Character temp_pattern = word_pattern_map.get(strArray[i]);
        		if(temp_word == null && temp_pattern == null) {
        			pattern_word_map.put(pattern.charAt(i), strArray[i]);
        			word_pattern_map.put(strArray[i], pattern.charAt(i));
        		}else if(temp_pattern != null && temp_word != null) {
        			if(!temp_word.equals(strArray[i])) {
        				flag = false;
        				break;
        			}
				}else if(temp_word == null || temp_pattern == null) {
					flag = false;
					break;
				}
        	}
        }else {
			return false;
		}
        return flag;
    }
	public static void main(String[] args) {
		WordPattern_290 pattern_word = new WordPattern_290();
		System.out.println(pattern_word.wordPattern("aaaa","dog dog dog dog"));
	}
	
}
