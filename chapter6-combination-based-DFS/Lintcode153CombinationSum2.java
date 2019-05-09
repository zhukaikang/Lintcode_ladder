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
            	//判断条件改为i!=index的原因：使重复的数字能够被加入进去。因为每个数字只会考虑一次（i +1），所以不会有同一个数字用多次的情况，
            	//碰到多个相同数字的情况时，i若已经不等于index，说明已经在考虑了这个数字之后又碰到了一次相同数值的数字，因此跳过防止重复解。
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
