package chapter8;
import java.util.*;

public class Lintcode494ImplementStackbyTwoQueues {
	Queue<Integer> a = new LinkedList<>();
    Queue<Integer> b = new LinkedList<>();
   
   public void push(int x) {
       // write your code here
       if(a.isEmpty()) {
           a.offer(x);
           while(!b.isEmpty()) {
               a.offer(b.poll());
           }
       }
       else{
           b.offer(x);
           while(!a.isEmpty()){
               b.offer(a.poll());
           }
       }
   }

   /*
    * @return: nothing
    */
   public void pop() {
       // write your code here
       if(!a.isEmpty()){
           a.poll();
       }
       else{
           b.poll();
       }
   }

   /*
    * @return: An integer
    */
   public int top() {
       // write your code here
       //Integer res = 0;
       if(!a.isEmpty()){
           return a.peek();
       } else{
           return b.peek();
       }
       //return res;
   }

   /*
    * @return: True if the stack is empty
    */
   public boolean isEmpty() {
       // write your code here
       return a.isEmpty() && b.isEmpty();
   }
   
   public static void main(String[] args) {
	   Lintcode494ImplementStackbyTwoQueues stack = new Lintcode494ImplementStackbyTwoQueues();
	   stack.push(1);
	   stack.pop();
	   stack.push(2);
	   System.out.println(stack.isEmpty());
	   System.out.println(stack.top());
	   stack.pop();
	   System.out.println(stack.isEmpty());
   }
}
