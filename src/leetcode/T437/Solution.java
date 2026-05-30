package leetcode.T437;

import java.util.HashMap;
import java.util.function.BiFunction;

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

    HashMap<Long,Integer> map = new HashMap<>();
    long prefit_sum = 0L;
    int ans = 0;

    public int pathSum(TreeNode root, int targetSum) {
        sft(root,targetSum);
        return ans;
    }

    public void sft(TreeNode root, int targetSum){
        if(root == null) {
            return;
        }
        prefit_sum+=root.val;
        if(prefit_sum==targetSum){
            ans++;
        }
        ans+=map.getOrDefault(prefit_sum-targetSum,0);
        map.putIfAbsent(prefit_sum,0);
        map.put(prefit_sum,map.get(prefit_sum)+1);
        sft(root.left,targetSum);
        sft(root.right,targetSum);
        map.compute(prefit_sum, (k,v)->v-1);
        prefit_sum-= root.val;
    }
}
