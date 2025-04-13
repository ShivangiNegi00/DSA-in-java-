import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;


// answer incorrect 
public class StoneGame {
    

     public static int giveWinner(ArrayList<Integer> arr,int player,int i,int samePile ) {
           if(i == arr.size()) {
              return player;
           }

           else if(samePile == 0 && arr.get(i) > 1) {
             if(player == 1) return giveWinner(arr,0,i,1);
             else return giveWinner(arr, 1, i, 1);
           }

           else if(samePile == 1 || arr.get(i) == 1) {
            if(player == 1) return giveWinner(arr,0,i+1,0);
            else return giveWinner(arr,1,i+1,0);
           }

           return -1;
        
            // if(player == 0) return giveWinner(arr, 1, i+1,0);
            
            // return giveWinner(arr, 0, i+1, 0);
           

    }
    public static void main(String[] args) throws IOException {
        // System.setIn( new FileInputStream('stoneTestcase.txt'));
        System.setIn(new FileInputStream("stoneTestCase.txt"));
         Scanner scanner = new Scanner(System.in);

         int t = scanner.nextInt();
        //  scanner.nextLine();
       for(int i=0;i<t;i++) { 
         ArrayList<Integer> arr = new ArrayList<>();
         String line = scanner.nextLine();
         String[] inputs =  line.trim().split("\\s+");
         for(String input : inputs) {
            if(!input.isEmpty())
               arr.add(Integer.parseInt(input));
         }

         char winner = 'B';
         if(giveWinner(arr, 1, 0,0) == 1) winner = 'A';

         System.out.println(winner);
        }

         scanner.close();
    }
}
