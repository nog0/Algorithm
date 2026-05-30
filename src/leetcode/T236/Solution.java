package leetcode.T236;

import sun.reflect.generics.tree.Tree;

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int maxn = 100005;
    int[][] array = new int[maxn][31];
    TreeNode[] t_array = new TreeNode[maxn];
    int[] depth = new int[maxn];
    int id;
    int x,y,x_id,y_id;
    TreeNode global_p;
    TreeNode global_q;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        global_p = p;
        global_q = q;
        dfs(root,0,0);
        if(x-y<0){
            int temp = x;
            int temp_id = x_id;
            x = y;
            x_id = y_id;
            y = temp;
            y_id = temp_id;
        }
        int dis = x - y;
        for(int j = 0;dis>0;j++,dis>>=1){
            if((1&dis)>0) {
                x_id = array[x_id][j];
            }
        }
        if(x_id==y_id){
            return t_array[x_id];
        }
        for(int j=30;j>=0;j--){
            if(array[x_id][j]!=array[y_id][j]){
                x_id = array[x_id][j];
                y_id = array[y_id][j];
            }
        }
        return t_array[array[x_id][0]];
    }

    public void dfs(TreeNode root, int parent,int cur_depth){
        if(root == null){
            return;
        }
        if(root == global_p){
            x = cur_depth;
            x_id = id;
        }
        if(root == global_q){
            y = cur_depth;
            y_id = id;
        }
        t_array[id] = root;
        depth[id] = cur_depth;
        int cur = id;
        for(int i = 0;i<31;i++){
            if(i==0){
                array[cur][i] = parent;
            }
            else{
                array[cur][i] = array[array[cur][i-1]][i-1];
            }
            if(array[cur][i]==0) break;
        }
        id++;
        dfs(root.left,cur,cur_depth+1);
        dfs(root.right,cur,cur_depth+1);
    }
}
