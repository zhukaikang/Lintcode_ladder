package chapter8;
import java.util.*;

public class LintCode209FirstUniqueLetterInaString {
	public char firstUniqChar(String str) {
        // Write your code here
        // if(str == null) {
        //     return '0';
        // }
        // int[] arr = new int[256];
        // for(int i=0;i<str.length();i++) {
        //     arr[str.charAt(i)] += 1;
        // }
        // for(int i=0;i<str.length();i++) {
        //     if(arr[str.charAt(i)]==1) {
        //         return str.charAt(i);
        //     }
        // }
        // return '0';
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++) {
            map.put(str.charAt(i), 0);
        }
        for(int i=0;i<str.length();i++) {
            map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
        }
        for(int i=0;i<str.length();i++) {
            if(map.get(str.charAt(i)) == 1) {
                return str.charAt(i);
            }
        }
        return '0';
    }
	
	public static void main(String[] args) {
		LintCode209FirstUniqueLetterInaString a = new LintCode209FirstUniqueLetterInaString();
		System.out.println(a.firstUniqChar("abaccdeff"));
	}
}
