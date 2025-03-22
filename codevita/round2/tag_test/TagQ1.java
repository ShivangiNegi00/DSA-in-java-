import java.util.*;

public class TagQ1 {

static Boolean isSubSequence(String s1, String s2){
  int n = s1.length() , m = s2.length();
  int i=0, j=0;

  while(i<n && j<m){
   if(s1.charAt(i) == s2.charAt(j)) {
      i++; j++;
}
else 
   j++;   
   
}
 if(i==n) return true; 
 return false;
}

public static void main(String args[]) {
   
Scanner scanner = new Scanner(System.in);
String s1 = scanner.next();
String s2 = scanner.next();
System.out.println(isSubSequence(s1,s2));


}

}