import java.io.IOException;
import java.util.*;


public class BusFare {

static double getFare(String source, String dest) {
int path[]= {800,600,750,900,1400,1200,1100,1500};
String busStops[]={"TH","GA","IC","HA","TE","LU","NI","CA"};
int srcIdx = 10,destIdx=10;
int finalDist = 0;
double fare;

 for(int i=0;i<busStops.length ; i++ ) {
  if (source.equals(busStops[i])) {
      srcIdx = i;
      
}
 if (dest.equals(busStops[i]) ){
      destIdx = i;
     
     }

}

if(srcIdx==10 || destIdx== 10) //considering that equal to is case sensitive for strings
{
  System.out.println("Invalid input");
  return -1;
}


for(int i=(srcIdx+1)%path.length; i!=destIdx+1;i=(i+1)% path.length) {

    finalDist += path[i];

}


     fare = Math.ceil(0.005*finalDist);
    return fare;

}



public static void main(String[] args)  {
Scanner scanner = new Scanner(System.in);
String src = scanner.next().trim();
String dest =  scanner.next().trim();
double fare = getFare(src,dest);

if(fare !=-1)
System.out.println(fare + "INR");


}

}
