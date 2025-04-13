import java.util.*;

public class NakliKho {


    public static void main(String[] args)
{
    Scanner scanner = new Scanner(System.in);
int n = scanner.nextInt();
int friends[] =  new int[n] ;

for(int i=0; i<n ; i++ ) {
 friends[i] =  scanner.nextInt();
}

int digit = friends[0];	
int count = 0 ;

for(int i=1; i<n;i++) {
   if (friends[i] != digit) 
       count++; 

}
 
System.out.println(count);
}


}