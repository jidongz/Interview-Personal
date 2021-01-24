package leetcode.tree;

public class $226_InvertBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if((root == null) || (root.left == null && root.right == null)){
            return  root;
        }

        TreeNode tempNode = root.right;
        root.right = root.left;
        root.left = tempNode;

        if(root.left !=null){
            invertTree(root.left);
        }

        if(root.right !=null){
            invertTree(root.right);
        }

        return root;
    }
}
