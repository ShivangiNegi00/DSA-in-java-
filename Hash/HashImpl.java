// package Hash;
import java.util.*;

public class HashImpl {
    static class HashMap<K,V> {
        private class Node {
            K key; // generic type K and V
            V value;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n; //no. of total nodes 
        private int N; //bucket or array size
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0 ; i<4; i++) {
                this.buckets[i] = new LinkedList<>(); // first create empty list to store our node . 
            }
        }
 
        private int hashFunction(K key) {
            int bi = key.hashCode();
            return Math.abs(bi) % N; // range of index 0 to N-1

        }

        private int searchInLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
        
            for(int i=0;i<ll.size();i++){
                     if(ll.get(i).key == key) { // is get method of  linked list????
                        return i; // di data index
                     }
            }

            return -1;
        }
  
        private void rehashing() {
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N*2];

            for(int i=0;i<N*2; i++){
                buckets[i] = new LinkedList<>();
            }

            for(int i=0; i<oldBucket.length;i++) {
                LinkedList<Node> ll = oldBucket[i]; // copy what ? the referenc or the whole linked list???
                for(int j=0;j<ll.size();j++){
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
             }
        }
        public void put(K key , V value) {
                int bi = hashFunction(key); // return a index for key 
                int di = searchInLL(key,bi); // key exits if it returns zero or greater than zero , if di = -1 then key doesn't exist

                if(di == -1) { // key doesn't exist
                    buckets[bi].add(new Node(key, value));
                    n++; // increment node as we are creating a new node 
                }
                else { //key exits 
                      Node data = buckets[bi].get(di);
                      data.value = value; // update the value of the key 
                }

                double lambda = (double)n/N;
               if(lambda > 2.0){
                //rehashing
               }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);

            if(di == -1){
                return false;
            }
            else{
                return true;
            }
        }


        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);//node in the LinkedList

            if(di == -1){
                return null;
            }
            else {
                Node node = buckets[bi].remove(di); // bi - linkedList Index , di-node index in LL
                n--;
                return node.value;
            }
        }

        public V get(K key) {
            int bi = hashFunction(key); // return a index for key 
                int di = searchInLL(key,bi); // key exits if it returns zero or greater than zero , if di = -1 then key doesn't exist

                if(di == -1) { // key doesn't exist
                    return null;

                }
                else { //key exits 
                      Node node= buckets[bi].get(di);
                      return  node.value; //  return the value
                }
        }
        
        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            
            for(int i=0; i<buckets.length; i++){
                LinkedList<Node> ll = buckets[i];
                for(int j=0;j<ll.size() ; j++ ){
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0; // is hashMap is empty i.e n==0 then return true
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>(); 
        map.put("India", 190);
        map.put("China",200);
        map.put("US",50);

        ArrayList<String> keys = map.keySet();
        for(int i=0; i<keys.size(); i++) {
            System.out.println(keys.get(i) + " " + map.get(keys.get(i)));
        }
    }
    
}
