package HashMap_String_LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class GroupAnagrams_49 {
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0) {
        	return result;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i=0; i<strs.length; i++){
        	char[] char_array = strs[i].toCharArray();
        	Arrays.sort(char_array);
        	String sort_string = new String(char_array);
        	if(!map.containsKey(sort_string)) {
        		map.put(sort_string, new ArrayList<>());
        	}
        	map.get(sort_string).add(strs[i]);
        }
        /*Iterator<Entry<String, List<String>>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
        	result.add(iterator.next().getValue());
        }*/
        return new ArrayList<>(map.values());
    }
}
