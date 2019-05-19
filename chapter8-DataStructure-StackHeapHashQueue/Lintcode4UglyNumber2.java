package chapter8;
import java.util.*;

public class Lintcode4UglyNumber2 {
	public static void main(String[] args) {
		Lintcode4UglyNumber2 a = new Lintcode4UglyNumber2();
		System.out.println(a.nthUglyNumber(10));
	}
	public int nthUglyNumber(int n) {
        // write your code here
	//过于数学不懂。
    //     if(n<=0){
    //         return -1;
    //     }
    //     int[] arr = new int[n];
    //     arr[0] = 1;
    //     int p2 = 0, p3=0,p5=0;
    //     for(int i=1;i<n;i++){
    //         arr[i]=Math.min(arr[p2]*2, Math.min(arr[p3]*3, arr[p5]*5));
    //         if(arr[i] == arr[p2]*2){
    //             p2++;
                
    //         }
    //         if(arr[i] == arr[p3]*3){
    //             p3++;
    //         }
    //         if(arr[i] == arr[p5]*5){
    //             p5++;
    //         }
    //     }
    //     return arr[n-1];
    // }
        Queue<Long> Q = new PriorityQueue<Long>();
        HashSet<Long> inQ = new HashSet<Long>();
        Long[] primes = new Long[3];
        primes[0] = Long.valueOf(2);
        primes[1] = Long.valueOf(3);
        primes[2] = Long.valueOf(5);
        for(int i=0;i<3;i++){
            Q.add(primes[i]);
            inQ.add(primes[i]);
        }
        Long number = Long.valueOf(1);
        for(int i=1;i<n;i++){
            number = Q.poll();
            for(int j=0;j<3;j++){
                if(inQ.contains(number*primes[j])){
                    continue;
                }
                Q.add(number*primes[j]);
                inQ.add(number*primes[j]);
            }
        }
        return number.intValue();
    }
}
