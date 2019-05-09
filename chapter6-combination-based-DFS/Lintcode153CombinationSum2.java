package chaper6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lintcode153CombinationSum2 {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> com = new ArrayList<>();
        Arrays.sort(num);
        dfs(num, 0, target, com, res);
        return res;
    }
    
    private void dfs(int[] num, int index, int target, List<Integer> com, List<List<Integer>> res) {
        if(target == 0){
            res.add(new ArrayList<>(com));
            return;
        }
        for(int i=index;i<num.length;i++) {
            if(num[i] > target) {
                break;
            }
            if(i!=index && num[i]==num[i-1]){
                continue;
            }
            com.add(num[i]);
            dfs(num, i+1, target - num[i], com, res);
            com.remove(com.size()-1);
        }
    }
    
    public static void main(String[] args) {
    	Lintcode153CombinationSum2 a = new Lintcode153CombinationSum2();
    	int[] num = {7,1,2,5,1,6,10};
    	System.out.println(a.combinationSum2(num, 8));
    }
}
