public class TrieQues {
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
                
                curr = curr.children[idx];

                if(i == word.length() -1 )
                       curr.eow = true;
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
        
      
        
    }
 
    //Q1
    public static boolean wordBreak(String key){
        if(key.length() == 0) {
            return true;
        }

        for(int i=1; i<=key.length(); i++) {
            String first_part = key.substring(0,i);
            String secPart = key.substring(i);
            if(TrieDS.search(first_part) && wordBreak(secPart)) {
                return true;
            }
        }

        return false;
      }


    //   Q2
      public static boolean startsWith(String key) {
        TrieDS.Node curr = TrieDS.root;
        for(int i=0; i<key.length();i++){
            int idx  = key.charAt(i) - 'a';

            if(curr.children[idx] == null){
                return false;
            }
                
            curr = curr.children[idx];
        }
        return true;
    }

    // Q3
    public static int countNode(TrieDS.Node root) {
       TrieDS.Node curr = root;
        if(root == null) {
            return 0;
        }
        int count = 0;
        for(int i=0; i<26; i++) {
            if(curr.children[i] != null) {
                count += countNode(curr.children[i]);
        
            }          
        }
        return count + 1;

    }
    public static String ans = "";
    public static void longestWord(TrieDS.Node root, StringBuilder temp) {
        if(root == null) {
            return;
        }

        for(int i=0; i<26; i++) {
            if(root.children[i] != null && root.children[i].eow == true) {
                temp.append((char)(i+'a'));   
                if(temp.length() > ans.length()) {
                    ans = temp.toString();
                }
    
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
          
            
        }
    }



    public static void main(String args[]) {
        //1. word break problem 
        // String words[] = {"i","like","sam","samsung","mobile"};
        // String key ="ilikesamsung";

        // for(int i=0;i<words.length;i++){
        //         TrieDS.insert(words[i]);
        // }

        // System.out.println(wordBreak(key));

        //2.starts with problem
        //   String words[] = {"apple","app","mango","man","woman"};
        //   String prefix = "oon";

        //   for(int i=0; i<words.length ; i++) {
        //     TrieDS.insert(words[i]);
        //   }

        //   System.out.println(startsWith(prefix));


        //3. Count Uniques subStrings
        // String str = "apple";

        // for(int i=0; i<str.length(); i++){
        //     String suffix = str.substring(i);
        //     TrieDS.insert(suffix);
        // }

        // System.out.println(countNode(TrieDS.root));

        // 4. Longest word with all the prefix "
        String words[] = { "a","banana","app","appl","ap","apply","apple"};
        for(int i=0; i<words.length; i++) {
            TrieDS.insert(words[i]);
        }
        
        longestWord(TrieDS.root, new StringBuilder(""));
        System.out.println(ans);


      }
    
}
