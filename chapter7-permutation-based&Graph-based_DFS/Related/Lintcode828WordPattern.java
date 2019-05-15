package chapter7;

import java.util.*;

public class Lintcode828WordPattern {
	public boolean wordPattern(String pattern, String teststr) {
        Map<Character, String> map = new HashMap<>();
        String[] str = teststr.split(" ");
        
        for(int i=0;i<pattern.length();i++) {
            char c = pattern.charAt(i);
            if(!map.containsKey(c)) {
                if(map.containsValue(str[i])){
                    return false;
                }
                map.put(c, str[i]);
            }
            else{
                if(!str[i].equals(map.get(c))){
                    return false;
                }
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		Lintcode828WordPattern a = new Lintcode828WordPattern();
		boolean res = a.wordPattern("abba", "dog cat cat dog");
		System.out.println(res);
	}
}
