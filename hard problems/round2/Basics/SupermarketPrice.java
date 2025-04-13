import java.util.*;

public class SupermarketPrice { 

public static void main(String[] args) {

Scanner scanner = new Scanner(System.in) ;
// int code = scanner.nextInt();
int price = 1;
int digit = 0;

String code = scanner.next();
for(char c : code.toCharArray() ) {
    price *= c - '0';
}

// while(code > 0) {
// digit = code % 10;
// price *= digit;
// code = code/10;

// }

System.out.println(price);

}


}