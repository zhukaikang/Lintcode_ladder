package chapter8;
import java.util.*;

public class Lintcode544TopKLargestNumbers {
	public int[] topk(int[] nums, int k) {
        // write your code here
        if(k>nums.length || nums.length==0){
            return null;
        }
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                //int difference = Integer.parseInt(a)-Integer.parseInt(b);
                int difference = a - b;
                return -1*difference;
            }
        });
        for(int num: nums){
            pQueue.add(num);
        }
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            int max = pQueue.poll();
            res[i] = max;
        }
        return res;
        
    }
	
	public static void main(String[] args) {
		Lintcode544TopKLargestNumbers a = new Lintcode544TopKLargestNumbers();
		int[] nums = {3, 10, 1000, -99, 4, 100};
		int[] res = a.topk(nums, 3);
		for(int num: res) {
			System.out.println(num);
		}
	}
}
