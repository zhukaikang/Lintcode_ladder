package chapter7;

import java.util.*;

public class Lintcode132WordSearch2 {
	public static int[] dx = {0, 1, -1, 0};
    public static int[] dy = {1, 0, 0, -1}; 
    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        List<String> res = new ArrayList<>();
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0 || words.size() == 0) {
            return res;
        }
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        Map<String, Boolean> map = getPrefixSet(words);
        Set<String> wordSet = new HashSet<>();
        
        for(int j = 0;j<row;j++){
            for(int k = 0;k<col;k++) {
                visited[j][k] = true;
                dfs(j, k, String.valueOf(board[j][k]), visited, board, map, wordSet);
                // dfs(board, visited, j, k, String.valueOf(board[j][k]), map, wordSet);
                visited[j][k] = false;
            }
        }
        return new ArrayList<String>(wordSet);
    }
    
    private Map<String, Boolean> getPrefixSet(List<String> words) {
        Map<String, Boolean> map = new HashMap<>();
        for(String word: words) {
            
            for(int i = 0;i<word.length()-1;i++) {
                String prefix = word.substring(0, i+1);
                if(!map.containsKey(prefix)){
                    map.put(prefix, false);
                }
            }
            map.put(word, true);
        }
        return map;
    }
    
    private void dfs(int row, int col, String word, boolean[][] visited, char[][] board, Map<String, Boolean> map, Set<String> set) {
        if(!map.containsKey(word)) {
            return;
        }
        if(map.get(word)) {
            set.add(word);
        }
        
        for(int i=0;i<4;i++) {
            int adx = dx[i] + row;
            int ady = dy[i] + col;
            // if(!inside(board, adx, ady) || visited[adx][ady]) {
            //     continue;
            // }
            if(adx < 0 || adx >= board.length || ady < 0 || ady >= board[0].length || visited[adx][ady]) {
                continue;
            }
            visited[adx][ady] = true;
            dfs(adx, ady, word + board[adx][ady], visited, board, map, set);
            visited[adx][ady] = false;
        }
        
        
    }
    
    private boolean inside(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }
    
    public static void main(String[] args) {
    	Lintcode132WordSearch2 a = new Lintcode132WordSearch2();
    	char[][] b = {{'d','o','a','f'},{'a','g','a','i'},{'d','c','a','n'}};
    	List<String> c = Arrays.asList("dog","dad","dgdg","can","again");
    	System.out.println(a.wordSearchII(b, c));
    }
}
