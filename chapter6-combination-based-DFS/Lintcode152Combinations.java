public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        // write your code here
        List<Integer> com = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, k, 1, com, res);
        return res;
    }
    
    private void dfs(int n, int k, int index, List<Integer> com, List<List<Integer>> res) {
        if(com.size()==k){
            res.add(new ArrayList<Integer>(com));
            return;
        }
        for(int i=index;i<=n;i++){
            com.add(i);
            dfs(n, k, i+1, com,res);
            com.remove(com.size()-1);
        }
    }
}