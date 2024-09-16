 public static void main(String args[]) {
        int values[] = {5,1,3,4,2,7,11,12,31,14};
        TreeNode root = null;

        for(int i=0 ; i<values.length; i++) {
            root = insert(root,values[i]);
        }

        inorder(root);
        System.out.println(search(root, 2));