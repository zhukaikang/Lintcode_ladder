public class Solution {
    /**
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        dfs(n, cols, res);
        return res.size();
    }
    
    private void dfs(int n, List<Integer> cols, List<List<Integer>> res) {
        if(cols.size()==n) {
            res.add(new ArrayList<Integer>(cols));
            return;
        }
        for(int i=0;i<n;i++){
            if(!isValid(cols, i)){
                continue;
            }
            cols.add(i);
            dfs(n, cols, res);
            cols.remove(cols.size()-1);
        }
    }
    
    private boolean isValid(List<Integer> cols, int index) {
        int rows = cols.size();
        for(int i=0;i<rows;i++) {
            if(cols.get(i)==index){
                return false;
            }
            if(cols.get(i) + i== index + rows)
                return false;
            if(cols.get(i) - i == index - rows)
                return false;
        }
        return true;
    }
}