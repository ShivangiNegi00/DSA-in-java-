import java.util.*;

public class GoodString {

public static void main(String args[]) {
Scanner scanner = new Scanner(System.in);
String good = scanner.next();
String name = scanner.next();

int goodAscii[] = new int[good.length()] ;
int distance = 0;


for(int i=0 ; i<good.length() ; i++ ) {
goodAscii[i] = (int) good.charAt(i); 

}

Arrays.sort(goodAscii);


for(int i=0; i<name.length() ; i++) {
int nearest = goodAscii[0];
int prevNearest = goodAscii[0] ;
int left = 0 ;
int right = goodAscii.length - 1;
int letter = (int) name.charAt(i);
 while(left <= right) {
  int mid = left + (right-left)/2;
  if(Math.abs(goodAscii[mid] - letter) < Math.abs(nearest - letter))
     nearest =  goodAscii[mid];

else if (Math.abs(goodAscii[mid]-letter) == Math.abs(nearest-letter)){
         nearest = prevNearest ;
     
  }
  
 if(goodAscii[mid] == letter) {
     nearest = goodAscii[mid];
     break;
     }
else if(goodAscii[mid] < letter)
       left = mid + 1;
else 
   right = mid - 1;

}

distance += Math.abs(letter-nearest);


}


System.out.println(distance);
}



}