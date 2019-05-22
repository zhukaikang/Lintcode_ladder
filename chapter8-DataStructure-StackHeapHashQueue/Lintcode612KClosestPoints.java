package chapter8;
import java.util.*;

class Point {
	 int x;
	 int y;
	 Point() { x = 0; y = 0; }
	 Point(int a, int b) { x = a; y = b; }

}

public class Lintcode612KClosestPoints {
	public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        // if(k>points.size()){
        //     return null;
        // }
        // if(k==points.size()){
        //     return points;
        // }
        PriorityQueue<Point> pQueue = new PriorityQueue<Point> (k, new Comparator<Point>(){
            @Override
            //Comparator函数无法重写int之外的数据类型。。想写double报错了
            //不必返回double类型，返回int类型表示大小关系即可。compare也只能用int类型。
            public int compare(Point a, Point b) {
                int difference = calDis(a, origin) - calDis(b, origin);
                if(difference==0){
                    difference = a.x - b.x;
                }
                if(difference==0){
                    difference = a.y - b.y;
                }
                return difference;
            }
        });
        HashMap<Double, Point> map = new HashMap<Double, Point>();
        Point[] sortedP = new Point[k];
        for(Point point: points){
            //double distance = calDis(point, origin);
            //map.put(distance, point);
            pQueue.add(point);
        }
        for(int i=0;i<k;i++){
            Point minP = pQueue.poll();
            //Point minP = map.get(minDis);
            sortedP[i] = minP;
        }
        return sortedP;
    }
    
    private int calDis(Point a, Point origin){
        int square = (a.x - origin.x)*(a.x - origin.x) + (a.y - origin.y)*(a.y - origin.y);
        return square;
    }
    
    public static void main(String[] args) {
    	Lintcode612KClosestPoints a = new Lintcode612KClosestPoints();
    	Point[] newP = new Point[5];
    	//ArrayList<Point> newP = new ArrayList<Point>();
    	newP[0] = new Point(4, 6);
    	newP[1] = new Point(4, 7);
    	newP[2] = new Point(4, 4);
    	newP[3] = new Point(2, 5);
    	newP[4] = new Point(1, 1);
//    	newP.add(new Point(4, 7));
//    	newP.add(new Point(4, 4));
//    	newP.add(new Point(2, 5));
//    	newP.add(new Point(1, 1));
    	Point[] res = a.kClosest(newP, new Point(0, 0), 3);
    	for(Point p: res) {
    		System.out.println(p.x + " " + p.y);
    	}
    }
}
