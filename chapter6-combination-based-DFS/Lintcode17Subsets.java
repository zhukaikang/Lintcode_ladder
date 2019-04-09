public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void dfs(int[] nums, int index, List<Integer> com, List<List<Integer>> result)
    {
        result.add(new ArrayList<Integer>(com));
        for(int i = index;i<nums.length;i++)
        {
            com.add(nums[i]);
            dfs(nums, i+1, com, result);
            com.remove(com.size()-1);
        }
    }
}
