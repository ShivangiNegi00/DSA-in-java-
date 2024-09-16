import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class HMap{
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        
        //Insertion
        map.put("India",120);
        map.put("US",50);
        map.put("China",150);

        System.out.println(map);
        map.put("China",180);
        System.out.println(map);

        //search
        if(map.containsKey("China")) {
            System.out.println("Key is present in the map");
        } else {
            System.out.println("Key is not present in the map");
        }

        // Iteration
        for(Entry<String, Integer> e: map.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }

        //Iterator for keys only 
        Set<String> keys = map.keySet();
        for(String key : keys ) {
            System.out.println(key + " " + map.get(key));
        }
    }
}


