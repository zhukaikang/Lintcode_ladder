package chapter8;

public class Lintcode128HashFunction {
	public static void main(String[] args) {
		Lintcode128HashFunction a = new Lintcode128HashFunction();
		System.out.println(a.hashCode(new char[] {'a','b','c','d'}, 1000));
	}
	public int hashCode(char[] key, int HASH_SIZE) {
        // write your code here
        long sum = 0;
        //同余定理，没搞懂。。循环相乘，见https://www.jianshu.com/p/9a67268b5a94
        for(int i=0;i<key.length;i++){
            sum = (sum*33+key[i]) % HASH_SIZE;
            
        }
        return (int)sum;
    }
}
