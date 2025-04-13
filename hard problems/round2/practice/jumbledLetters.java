import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class jumbledLetters {

    public static void arrangeString(String p, String s) {

        char[] order = new char[26];
        for(int i = 0; i < p.length(); i++) {
            order[i] = p.charAt(i);
        }

        int[] stringMap = new int[s.length()];
        for(int i=0; i<stringMap.length; i++) {
            for(int j=0;j<order.length; j++) {
                if(s.charAt(i) == order[j]) {
                    stringMap[i] = j;
                    break;
                }
            }
        }

        Arrays.sort(stringMap);
    
        System.out.println(s);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<stringMap.length; i++) {
            sb.append(p.charAt(stringMap[i]));
        }

        System.out.println(sb.toString());

    }
    public static void main(String[] args)  throws IOException {
        System.setIn(new FileInputStream("jumbled.txt"));
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // number of test cases
        scanner.nextLine();
        for (int i = 0; i< t; i++) {
            String p = scanner.nextLine(); // the jumbled word
            String s = scanner.nextLine(); 
            arrangeString(p,s); 
        }
       

    } 
}
