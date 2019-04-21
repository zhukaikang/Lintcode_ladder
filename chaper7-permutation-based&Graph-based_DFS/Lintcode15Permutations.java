public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> per = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new boolean[nums.length], per, res);
        return res;
    }
    
    private void dfs(int[] nums, boolean[] visited, List<Integer> per, List<List<Integer>> res) 
    {
        if(per.size() == nums.length)
        {
            res.add(new ArrayList<Integer>(per));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(visited[i]==true)
            {
                continue;
            }
            per.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, per, res);
            visited[i] = false;
            per.remove(per.size()-1);
        }
    }
}