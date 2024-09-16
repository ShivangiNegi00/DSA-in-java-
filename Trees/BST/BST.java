import java.util.*;
public class BST {
    static class TreeNode {
        int val;
        TreeNode leftNode;
        TreeNode rightNode;
        
        TreeNode(int val) {
            this.val = val;
            
        }
    }
    
    public static TreeNode insert(TreeNode root,int val) {
        if(root == null) {
            root = new TreeNode(val);
            return root;
        }

        if(root.val > val) {
            root.leftNode = insert(root.leftNode ,val);
        }

        else {
            root.rightNode = insert(root.rightNode , val);
        }

        return root;
    }
    
    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.leftNode);
        System.out.print(root.val + " ");
        inorder(root.rightNode);
    }

    public static boolean search(TreeNode root, int key ) {
      if(root == null) {
       return false;
      }

        if(root.val > key) { 
            return search(root.leftNode, key) ;
        }

        else if(root.val == key) {
            return true;
        }

        else {
            return search(root.rightNode, key);
        }

    }

    public static TreeNode delete(TreeNode root, int val) {
        if(root.val > val) {
            root.leftNode = delete(root.leftNode, val); // store in left Node to update our tree after deleting the node
        }

        else if (root.val == val) {
            //case 1
            if(root.leftNode == null & root.rightNode == null) {
                return null;
            }

            //case 2
            if(root.leftNode == null) {
                return root.rightNode;
            }
            else if(root.rightNode == null) {
                return root.leftNode;
            }

            //case 3
            TreeNode IS = inorderSuccessor(root.rightNode) ;
            root.val = IS.val; //store the successor node 
            root.rightNode = delete(root.rightNode, IS.val); // now delete the successor node and update the tree
            
        }

        else {
            root.rightNode = delete(root.rightNode, val);
        }

        return root;
    }

    public static TreeNode inorderSuccessor(TreeNode root) {
        while(root.leftNode != null) {
            root = root.leftNode;
        }

        return root;
    }


    
    public static void printInRange(TreeNode root, int min, int max) {
        if (root == null) {
            return;
        }
        if(  min <= root.val &&  max >= root.val) {
                     printInRange(root.leftNode, min, max);
                     System.out.print(root.val+" ");
                     printInRange(root.rightNode, min, max);
        }

        else if (min >= root.val) {
            printInRange(root.rightNode, min, max);
        }

        else if (max <= root.val){
            printInRange(root.leftNode, min, max);        }
    }


    public static void printPath(ArrayList<Integer> path) {
        for(int i=0; i<path.size(); i++) {
            System.out.print(path.get(i)+"-->");
        }

        System.out.println();
    }
    public static void printRoot2Leaf(TreeNode root,ArrayList<Integer> path) {
        if(root == null) {
            return;
        }

        path.add(root.val);

        //when leaf is encountered 
        if(root.leftNode == null && root.rightNode == null) {
            printPath(path);
        } else {
            printRoot2Leaf(root.leftNode, path);
            printRoot2Leaf(root.rightNode, path);
        }

        path.remove(path.size()-1);
    }



    public static void main(String args[]) {
        int values[] = {8,5,3,6,10,11,14};
        TreeNode root = null;

        for(int i=0 ; i<values.length; i++) {
            root = insert(root,values[i]);
        }

        inorder(root);
System.out.println();
        printRoot2Leaf(root, new ArrayList<>());
        // System.out.println();
        // printInRange(root, 6, 10);

        // if(search(root, 2)){
        //     System.out.println("found");
        // }
        // else{
        //     System.out.println("not found");

        // }

        //  delete(root,4);
        //  inorder(root);

    }
}
