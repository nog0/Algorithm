package leetcode.T94;

import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderTraversal(ans,root);
        return ans;
    }

    public void inorderTraversal(List<Integer> list,TreeNode root){
        if(root==null){
            return;
        }
        inorderTraversal(list,root.left);
        list.add(root.val);
        inorderTraversal(list,root.right);
    }
}
