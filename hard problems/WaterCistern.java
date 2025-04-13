import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class WaterCistern {
    static int minDistance = Integer.MAX_VALUE;

   public static int curvedSurfaceDistance(int r, int h, int s, int distance, int degree) {
       if (degree > 180) {
              degree = 360 - degree;
       }
        int  arcDistance = (int) (2 * Math.PI * r * degree / 360);
       
       minDistance = Math.abs(s-distance) + arcDistance;
       return minDistance;

    }
    
    public static int topSurfaceDistance(int r, int h, int s, int distance, int degree) {

            if (degree < 57 || degree > 303){
                 
             int  arcDistance = (int) (2 * Math.PI * r * degree / 360);
             minDistance = s + (r-distance) + arcDistance;
            }

            else {
                minDistance = s + r + distance;

            }
            return minDistance;
    }
    public static int findMinDistance(int r, int h, int s, int distance, int degree) {
       
        if (distance < 0) {
            return topSurfaceDistance(r, h, s, distance, degree);
        }

        return curvedSurfaceDistance(r, h, s, distance, degree);

    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("waterCisTestcase.txt"));
        Scanner scanner = new Scanner(System.in);

        int r = scanner.nextInt();
        int h = scanner.nextInt();  
        int s = scanner.nextInt();

        int distance = scanner.nextInt();
        int degree = scanner.nextInt();

        int result = findMinDistance(r, h, s, distance, degree);
        System.out.println(result);

    }
}
