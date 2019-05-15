package chaper4;

import java.util.*;


public class Lintcode120WordLadder {
	public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if(dict == null) {
            return 0;
        }
        if(start.equals(end)) {
            return 1;
        }
        
        dict.add(start);
        dict.add(end);
        
        HashSet<String> hash = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        hash.add(start);
        
        int length = 1;
        while(!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for(int i = 0;i<size;i++) {
                String word = queue.poll();
                for(String s : getNext(word, dict)) {
                    if(hash.contains(s)) {
                        continue;
                    }
                    if(s.equals(end)) {
                        return length;
                    }
                    hash.add(s);
                    queue.offer(s);
                }
            }
        }
        return 0;
    }
    
    private List<String> getNext(String word, Set<String> dict) {
        List<String> newWords = new ArrayList<String>();
        for(char c = 'a';c<='z';c++) {
            for(int i=0;i<word.length();i++) {
                if(c==word.charAt(i)) {
                    continue;
                }
                String newWord = replace(word, c, i);
                if(dict.contains(newWord)){
                    newWords.add(newWord);    
                }
            }
        }
        return newWords;
    }
    
    private String replace(String word, char c, int index) {
        char[] chars = word.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
    
    public static void main(String[] args) {
    	Lintcode120WordLadder a = new Lintcode120WordLadder();
    	Set<String> set = new HashSet<>(Arrays.asList("hot","dot","dog","lot","log"));
    	System.out.println(a.ladderLength("hit", "cog", set));
    }
}
