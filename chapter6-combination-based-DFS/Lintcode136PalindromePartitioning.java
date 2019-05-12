package chaper6;

import java.util.ArrayList;
import java.util.List;

public class Lintcode136PalindromePartitioning {
	public List<List<String>> partition(String s) {
        // write your code here
        
        List<List<String>> res = new ArrayList<>();
        List<String> com = new ArrayList<>();
        if(s.length() == 0 || s == null) {
            return res;
        }
        dfs(0, s, com, res);
        return res;
    }
    
    private void dfs(int index, String s, List<String> com, List<List<String>> res) {
        if(s.equals("")) {
            res.add(new ArrayList<String>(com));
            return;
        }
        for(int i = 1; i<=s.length();i++) {
            if(!isPalindrome(s.substring(0, i))) {
                continue;
            }
            com.add(s.substring(0, i));
            dfs(i, s.substring(i), com, res);
            com.remove(com.size()-1);
        }
    }
    
    private boolean isPalindrome(String s) {
        for(int i=0; i<s.length()/2;i++) {
            if(s.charAt(i) != s.charAt(s.length()-i-1)) {
                return false;
                
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
    	Lintcode136PalindromePartitioning a = new Lintcode136PalindromePartitioning();
    	System.out.println(a.partition("aab"));
    }
}
