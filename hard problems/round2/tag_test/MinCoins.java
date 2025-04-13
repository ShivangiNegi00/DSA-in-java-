
import java.util.*;
public class MinCoins {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        int one = 0 ; int two = 0;
        int five =  (number-4)/5;

        if((number-5*five) % 2 == 0 ) {
            
            one = 2;

        }

        else { 

        one = 1;
        }


        two = (number - 5*five - one ) / 2;



        System.out.print(five+one+two);
        System.out.println(" " + five + " " + two + " " + one);



 }
}
