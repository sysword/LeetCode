package HashMap_String_LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class RepeatedDNA_187 {
	public List<String> findRepeatedDnaSequences(String s) {
	    List<String> result = new ArrayList<>();
	    HashMap<String, Integer> map = new HashMap<>();
	    for(int i=0; i<s.length(); i++) {
	    	String temp = s.substring(i, i+10);
	    	if(!map.containsKey(temp)) {
	    		map.put(temp, 1);
	    	}else {
				map.put(temp, map.get(temp) + 1);
			}
	    }
	    Iterator<Entry<String, Integer>> iterator = map.entrySet().iterator();
	    while(iterator.hasNext()) {
	    	Entry<String, Integer> entry = iterator.next();
	    	if(entry.getValue() > 1) {
	    		result.add(entry.getKey());
	    	}
	    }
	    return result;
	}
	
	public List<String> findRepeatedDnaSequences2(String s){
		List<String> result = new ArrayList<>();
		return result;
	}
	
	
	
}
