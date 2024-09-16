import java.util.*;

public class BasicQues {
    static class Node{
        int data;
        Node left;
        Node right;
        
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1) {;
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }


    public static int countOfNodes(Node root) {
        if(root == null){
             return 0;
        }

        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);

        return leftNodes + rightNodes + 1;
    }

    public static int sumOfNodes(Node root) {
        if(root == null){
             return 0;
        }

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum + rightSum + root.data;
    }


    public static int height(Node root) {
        if(root ==  null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int myHeight = Math.max(leftHeight,rightHeight) + 1;

        return myHeight;
    }

    public static int diameter(Node root) {
        if(root == null) {
            return 0;
        }

        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = height(root.left) + height(root.right) + 1;

        return Math.max(diam3,Math.max(diam1,diam2));

    }

    static class TreeInfo {
        int ht;
        int diam;

        TreeInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static TreeInfo diameter2(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }
        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);
        int myheight = Math.max(left.ht,right.ht) + 1;
        
        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;

        int myDiam = Math.max(Math.max(diam1,diam2),diam3);
        TreeInfo myInfo = new TreeInfo(myheight, myDiam);
        return myInfo;

    }
    

    public static void main(String args[]){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        // System.out.println("No. of nodes in this tree are : " + countOfNodes(root) );
        // // System.out.println("Sum of nodes in this tree is : " + sumOfNodes(root) );
        // System.out.println("Height of this tree is : " + height(root) );
        // System.out.println("Diameter of this tree is : " + diameter(root) );
        System.out.println("Diameter of this tree using approach 2 : " + diameter2(root).diam );


 

    }



    

}