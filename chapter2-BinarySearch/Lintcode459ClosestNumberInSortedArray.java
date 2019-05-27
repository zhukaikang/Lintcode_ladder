package chapter2;

public class Lintcode459ClosestNumberInSortedArray {
	
	public static void main(String[] args) {
		Lintcode459ClosestNumberInSortedArray a = new Lintcode459ClosestNumberInSortedArray();
		System.out.println(a.closestNumber(new int[] {1,4,6}, 3));
	}
	
	public int closestNumber(int[] A, int target) {
        // write your code here
        if(A==null || A.length == 0){
            return -1;
        }
        int left = 0, right = A.length - 1;
        while(left < right - 1){
            int mid = left + (right - left)/2;
        	if(A[mid] == target){
        		return mid;
        	}
        	else if(A[mid] > target){
        		right = mid;
        	}
        	else {
        		left = mid;
        	}
        	
        }
    	if(Math.abs(A[left] - target) > Math.abs(A[right] - target)){
    		return right;
    	}
    	else {
    		return left;
    	}
    }
}
