package chapter8;
import java.util.*;

public class LintCode642MovingAveragefromDataStream {
	private Queue<Integer> deq;
    private int size;
    private double sum;
    /*
    * @param size: An integer
    */public LintCode642MovingAveragefromDataStream(int size) {
        // do intialization if necessary
        deq = new LinkedList<Integer>();
        sum = 0.0;
        this.size = size;
    }

    /*
     * @param val: An integer
     * @return:  
     */
    public double next(int val) {
        // write your code here
        sum += val;
        //对队列元素个数进行判断，若没有达到size则添加后返回均值；若达到了size，则意味着滑动窗口往后移动一位
        //将队首元素拿出，sum减去对应值。此时若返回则没有将新元素加入（之前犯了这个错误）。将新元素加入后，
        //正常计算均值，队列始终保持size的大小，所以不用分别对待。
        if(deq.size() == size){
            sum -= deq.poll();
            //return sum/(1.0*size);
        }
        deq.offer(val);
        return sum/(1.0*deq.size());
    }
    
    public static void main(String[] args) {
    	LintCode642MovingAveragefromDataStream a = new LintCode642MovingAveragefromDataStream(3);
    	System.out.println(a.next(1));
    	System.out.println(a.next(3));
    	System.out.println(a.next(10));
    	System.out.println(a.next(5));
    }
}
