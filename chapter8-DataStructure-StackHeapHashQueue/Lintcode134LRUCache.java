package chapter8;
import java.util.*;

public class Lintcode134LRUCache {
	int cap;
    Map<Integer, Integer> map;
    public static void main(String[] args) {
    	Lintcode134LRUCache a = new Lintcode134LRUCache(2);
    	a.set(2,1);
    	a.set(1, 1);
    	System.out.println(a.get(2));
    	a.set(4, 1);
    	System.out.println(a.get(1));
    	System.out.println(a.get(2));
    }
    /*
    * @param capacity: An integer
    */public Lintcode134LRUCache(int capacity) {
        // do intialization if necessary
        cap = capacity;
        map = new LinkedHashMap<Integer, Integer>();
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if(!map.containsKey(key)){
            return -1;
        }
        int val = map.remove(key);
        map.put(key, val);
        return val;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if(map.containsKey(key)){
            map.remove(key);
            map.put(key, value);
            return;
        }
        map.put(key, value);
        if(map.size()>cap){
            map.remove(map.entrySet().iterator().next().getKey());
            
        }
        
        
    }
}
