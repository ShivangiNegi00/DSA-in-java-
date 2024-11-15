public class TrieDS {
    static class Node {
        Node[] children;
        boolean eow; // end of word 

        public Node() {
            children = new Node[26]; // and array of size 26
            for(int i=0; i<26; i++) {
                children[i] = null; // putting null value in the indexes  to remove garbage value
            }
            eow = false;
        }
    }

    static Node root = new Node(); // static varibale , if once changed it will be modified forever 

    public static void insert(String word) {
        Node curr = root; // hence using a different variable referenced to root 
        for(int i=0;i<word.length() ; i++){

            int idx = word.charAt(i) - 'a';

            if(curr.children[idx] == null) {
                 curr.children[idx] = new Node();
            }
            
            if(i == word.length() -1 )
                   curr.eow = true;
            curr = curr.children[idx];
        }
    }

    public static boolean search(String key) {
        Node curr = root;
        for(int i=0; i<key.length();i++){
            int idx  = key.charAt(i) - 'a';

            if(curr.children[idx] == null){
                return false;
            }
            
            if(i == key.length()-1 && curr.children[idx].eow == false) {
                return false;
            }

            curr = curr.children[idx];
        }
        return true;
    }
    

    
    public static void main(String args[]) {
        String words[] = {"the","a","there","their","any"};
        for(int i=0; i<words.length; i++) {
            insert(words[i]); // calling insert function for each word in the array
        }

        System.out.println(search("their"));//true
        System.out.println(search("thor"));//false
        System.out.println(search("an"));//false
    }


}
