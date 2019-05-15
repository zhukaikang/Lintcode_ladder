package chapter7;
import java.util.*;

public class LintCode33NQueens {
	public List<List<String>> solveNQueens(int n) {
        // write your code here
        // write your code here
	List<List<String>> res = new ArrayList<>();
	if(n<=0){
	    return res;
    }
    search(res, new ArrayList<Integer>(), n);
    return res;
    }
    
    private void search(List<List<String>> res, List<Integer> cols, int n){
    	if(cols.size() == n){
    		res.add(drawChess(cols));
    		return;
    	}
    	for(int colIndex = 0; colIndex < n;colIndex++){
    	if(!isValid(cols, colIndex)) {
    		continue;
    	}
    	cols.add(colIndex);
    	search(res, cols, n);
    	cols.remove(cols.size()-1);
    	}
    }
    
    private boolean isValid(List<Integer> cols, int col) {
    	int rows = cols.size();
    	for(int rowIndex=0; rowIndex < rows; rowIndex++) {
    		if(cols.get(rowIndex) == col) {
    		return false; }
    		if(cols.get(rowIndex) + rowIndex == col + rows) {
    		return false; }
    		if(cols.get(rowIndex) - rowIndex == col - rows) {
    		return false; }
    	}
    	return true;
    }
    
    private List<String> drawChess ( List<Integer> cols) {
    	List<String> chess = new ArrayList<>();
    	for(int i = 0;i< cols.size(); i++) {
    	StringBuilder sb = new StringBuilder();
    	for(int j=0;j<cols.size(); j++) {
    	sb.append(j == cols.get(i)?'Q':'.');
        }
        chess.add(sb.toString());
        }
        return chess;
    }
    
    public static void main(String[] args) {
    	LintCode33NQueens a = new LintCode33NQueens();
    	System.out.println(a.solveNQueens(4));
    }
}
