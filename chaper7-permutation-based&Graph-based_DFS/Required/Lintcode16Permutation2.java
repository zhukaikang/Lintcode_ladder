public class Solution {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<Integer> per = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new boolean[nums.length], per, res);
        return res;
    }
    
    private void dfs(int[] nums, boolean[] visited, List<Integer> per, List<List<Integer>> res) {
        if(nums.length==per.size()){
            res.add(new ArrayList<Integer>(per));
            return;
        }
        for(int i=0;i<nums.length;i++) {
            if(visited[i]){
                continue;
            }
            if(i>0 && nums[i]==nums[i-1] && !visited[i-1]) {
                continue;
            }
            per.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, per, res);
            visited[i] = false;
            per.remove(per.size()-1);
        }
    }
};