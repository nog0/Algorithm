package leetcode.T543;

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        extracted(root);
        return max;
    }

    public int extracted(TreeNode root) {
        if(root ==null){
            return 0;
        }
        int left_depth = extracted(root.left);
        int right_depth = extracted(root.right);
        if (max<left_depth+right_depth){
            max = left_depth+right_depth;
        }
        return Math.max(left_depth,right_depth)+1;
    }
}
