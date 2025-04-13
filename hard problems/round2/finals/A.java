import java.io.FileInputStream;
import java.util.*;

public class A {

     static class Point {
        int x, y;
        Point(int a, int b) {
            x=a;
            y=b;
        }
    }

    static int orientation(Point p, Point q, Point r) {
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if(val == 0) return 0;
        return (val > 0) ? 1 : 2; //we need counterclockwise that is non-positive value - 2
    }

    static double distance(Point p1, Point p2) {
        return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
    }
    
    public static void main(String[] args){
        Scanner scanner  = new Scanner(System.in);
        int n = scanner.nextInt();

        Point points[] = new Point[n];
        for(int i=0;i<n;i++){
          points[i] = new Point(scanner.nextInt(),scanner.nextInt());
        }

        // Arrays.sort(points,(a,b)-> Integer.compare(a.x,b.y));
        Arrays.sort(points, (a, b) -> (a.x == b.x) ? Integer.compare(a.y, b.y) : Integer.compare(a.x, b.x));

        Stack<Point> hull = new Stack<>();
        for(int i=0;i<n;i++) {
            while(hull.size() >= 2 && orientation(hull.get(hull.size()-2), hull.get(hull.size()-1), points[i]) <= 1) {
                hull.pop();
            }
            hull.push(points[i]);
        } 

        double perimeter = 0;
        for (int i = 1; i < hull.size(); i++) {
            perimeter += distance(hull.get(i - 1), hull.get(i));
        }
        int roundedPerimeter = (int) Math.round(perimeter);
        System.out.println( roundedPerimeter);


    }
    
}

