import java.util.*;

public class SpiralDist {
    public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 int n = scanner.nextInt();
 int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
int x=0, y=0, dis = 0;

  for(int i=0, j =0 ; i<n; j = (j+1)%dir.length, i++ ){
     dis += 10;
     x += dir[j][0]*dis;
     y += dir[j][1]*dis;

}

System.out.println(x + " " + y);

}
}
