package chapter7;

import java.util.ArrayList;
import java.util.List;

public class Lintcode425LetterCombinationsofaPhoneNumber {
	public List<String> letterCombinations(String digits) {
        // write your code here
        String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        if(digits.equals("") || digits == null) {
            return res;
        }
        
        
        dfs(0, digits.length(), "", digits, phone, res);
        return res;
    }
    
    private void dfs(int l, int r, String str, String digits, String[] phone, List<String> res) {
        if(l == r){
            res.add(str);
            return;
        }
        int d = digits.charAt(l)-'0';
        // for(int i=0;i<phone[d].toCharArray().length;i++) {
        //     str += phone[d].toCharArray()[i];
        //     dfs(i+1, r, str, digits, phone, res);
        // }
        for(char c: phone[d].toCharArray()){//啥意思？？？？
            dfs(l+1, r, str+c, digits, phone, res);
        }
    }
    public static void main(String[] args) {
    	Lintcode425LetterCombinationsofaPhoneNumber a = new Lintcode425LetterCombinationsofaPhoneNumber();
    	System.out.println(a.letterCombinations("23"));
    }
}
