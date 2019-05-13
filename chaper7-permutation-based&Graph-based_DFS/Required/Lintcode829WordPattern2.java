package chapter7;

import java.util.HashMap;
import java.util.Map;

public class Lintcode829WordPattern2 {
	public boolean wordPatternMatch(String pattern, String str) {
        // write your code here
        Map<Character, String> map = new HashMap<>();
        return dfs(pattern, str, map);
        
    }
    
    private boolean dfs(String pattern, String str, Map<Character, String> map) {
        if(pattern.length() == 0 && str.length() == 0) {
            return true;
        }
        if(pattern.length() == 0 || str.length() == 0) {
            return false;
        }
        
        if(map.containsKey(pattern.charAt(0))) {
            String prefix = map.get(pattern.charAt(0));
            if(!str.startsWith(prefix)) {
                return false;
            }
            return dfs(pattern.substring(1), str.substring(prefix.length()), map);
        }
        
        for(int i = 1;i <= str.length();i++) {
            String prefix = str.substring(0, i);
            if(map.containsValue(prefix)) {
                continue;
            }
            map.put(pattern.charAt(0), prefix);
            if(dfs(pattern.substring(1), str.substring(prefix.length()), map)){
                return true;
            }
            map.remove(pattern.charAt(0));
            
        }
        return false;
    }
    
    public static void main(String[] args) {
    	Lintcode829WordPattern2 a = new Lintcode829WordPattern2();
    	System.out.println(a.wordPatternMatch("abab", "redblueredblue"));
    	
    }
}
