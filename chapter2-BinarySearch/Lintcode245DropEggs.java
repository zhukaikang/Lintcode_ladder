package chapter2;

public class Lintcode245DropEggs {
	public static void main(String[] args) {
		Lintcode245DropEggs a = new Lintcode245DropEggs();
		System.out.println(a.dropEggs(100));
	}
	public int dropEggs(int n) {
		//TC O(logn)
        //SC O(1)
		long index = 1;
		while(index * (index + 1)/2 < n){
			index = index * 2;
		}
		long left = 0, right = index;
		while(left < right -1){
			long mid = left + (right - left)/2;
			if(mid * (mid + 1)/2 >= n){
				right = mid;
			}
			else{
				left = mid;
	}	
			
	}
	if(left * (left + 1)/2 >= n){
		return (int)left;
	}
	else {
		return (int)right;
	}
	//return 0;
}

}
