import java.util.*;

public class Itinerary {
    public static String getStart(HashMap<String,String> ticket){
        HashMap<String,String> revTicket = new HashMap<>();
        
        for(String key : ticket.keySet()){
            revTicket.put(ticket.get(key), key);
        }

        for(String key : ticket.keySet()) {
            if(!revTicket.containsKey(key)) 
            return key;
        }
        return null; 

    }


    public static void main(String args[]) {
        HashMap<String,String> ticket = new HashMap<>();
        ticket.put("Chennai","Bengaluru");
        ticket.put("Mumbai","Delhi");
        ticket.put("Goa","Chennai");
        ticket.put("Delhi","Goa");

        String start = getStart(ticket);

        while(ticket.containsKey(start)) {
            System.out.print(start + " -> ");
            start = ticket.get(start);
        }

        System.out.print(start); // to print the last destination since it is not a key (from)
    }
}
