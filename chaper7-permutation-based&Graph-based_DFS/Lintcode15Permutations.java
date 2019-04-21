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
    //递归的定义
    private void dfs(int[] nums, boolean[] visited, List<Integer> per, List<List<Integer>> res) 
    {
        // 递归的出口
        if(per.size() == nums.length)
        {
            res.add(new ArrayList<Integer>(per));
            return;
        }
        // 3.递归的拆解
        for(int i=0;i<nums.length;i++)
        {
            if(visited[i]==true)
            {
                continue;
            }
            //[] --> [1]
            per.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, per, res);
            //[1] --> []
            visited[i] = false;
            per.remove(per.size()-1);
        }
    }
}
