package chapter7;

public class Lintcode123WordSearch {
	public boolean exist(char[][] board, String word) {
        // write your code here
        
        if(board == null || board.length == 0) {
            return false;
        }
        if(board[0] == null || board[0].length == 0) {
            return false;
        }
        
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        //从每个元素依次寻找。
        //base case: index == word.length()
        //subProblem: 判断每个元素是否在board里
        //recursion rule: search(row, col +/-1) || search(row+/-1, col)是否为true
        //time complexity : O(i*j*n) n = words.length(), i = row, j = col
        //space complexity : O(i*j)
        for(int i = 0;i<row;i++) {
            for(int j = 0;j<col;j++) {
                if(search(i, j, 0, visited, board, word)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean search(int row, int col, int index, boolean[][] visited, char[][] board, String word) {
        if(index == word.length()) {
            return true;
        }
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if(visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }
        visited[row][col] = true;
        if(search(row, col - 1, index + 1, visited, board, word) ||
           search(row, col + 1, index + 1, visited, board, word) ||
           search(row - 1, col, index + 1, visited, board, word) ||
           search(row + 1, col, index + 1, visited, board, word)) {
               return true;
           }
        //若上下左右都没有找到对应的下一个元素，则将true改回false。
        visited[row][col] = false;
        return false;
        
    }
    
    public static void main(String[] args) {
    	Lintcode123WordSearch a = new Lintcode123WordSearch(); 
    	char[][] b = {{'A', 'B', 'C', 'E'}, {'S','F','C','F'}, {'A', 'D', 'E', 'E'}};
    	char[][] c = {{'z'}};
    	System.out.println(a.exist(c, "z"));
    	
    }
}
