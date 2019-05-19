package chapter8;
import java.util.*;

public class Lintcode657InsertDeleteGetRandomO1 {
	ArrayList<Integer> arr;
    HashMap<Integer, Integer> map;
    Random rand;
    public static void main(String[] args) {
    	
    }
    public Lintcode657InsertDeleteGetRandomO1() {
        // do intialization if necessary
        arr = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
        
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        // write your code here
        if(map.containsKey(val)){
            return false;
        }
        map.put(val, arr.size());
        arr.add(val);
        return true;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        // write your code here
        if(!map.containsKey(val)){
            return false;
        }
        
        int index = map.get(val);
        if(index<arr.size()-1){
            int last = arr.get(arr.size()-1);
            arr.set(index, last);
            //加不加这句话都可以通过，why?
            //arr.set(arr.size()-1, val);
            //Re: 把需要remove的数替换掉即可，不需要swap。
            map.put(last, index);
        }
        arr.remove(arr.size()-1);
        map.remove(val);
        return true;
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        // write your code here
        return arr.get(rand.nextInt(arr.size()));
    }
}
