package chapter8;
import java.util.*;

public class Lintcode685FirstUniqueNumberInDataStream {
	public static void main(String[] args) {
		Lintcode685FirstUniqueNumberInDataStream a = new Lintcode685FirstUniqueNumberInDataStream();
		System.out.println(a.firstUniqueNumber(new int[] {1, 2, 2, 1, 3, 4, 4, 5, 6}, 5));
	}
	public int firstUniqueNumber(int[] nums, int number) {
        // Write your code here
		//HashMap不允许键值重复，所以没必要用set。
		HashMap<Integer, Boolean> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        if(nums==null||nums.length==0){
            return -1;
        }
        for(int num: nums) {
            map.put(num, !map.containsKey(num));
            if(num==number){
                break;
            }
        }
        if(!map.containsKey(number)){
            return -1;
        }
        for(int num: nums){
            if(num==number){
                return num;
                //break;
            }
            if(map.get(num)){
                return num;
            }
        }
        return -1;
    }
}
