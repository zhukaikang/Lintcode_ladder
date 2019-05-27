package chapter2;

public class Lintcode458LastPositionfTarget {
	public int lastPosition(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length == 0){
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while(left<right-1){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                left = mid;
            }
            else if(nums[mid] > target){
                right = mid-1;
            } else{
                left = mid + 1;
            }
        }
        if(nums[right] == target){
            return right;
        }
        if(nums[left] == target){
            return left;
        }
        return -1;
    }
	
	public static void main(String[] args) {
		Lintcode458LastPositionfTarget a = new Lintcode458LastPositionfTarget();
		System.out.println(a.lastPosition(new int[] {1,2,2,4,5,5}, 6));
	}
}
