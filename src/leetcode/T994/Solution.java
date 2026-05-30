package leetcode.T994;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public static class Node {
        public int i;
        public int j;
        public Node(int i,int j) {
            this.i = i;
            this.j = j;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Node> queue = new ArrayDeque<>();
        int new_orange = 0;
        int cur_old_orange = 0;
        int next_old_orange = 0;
        int ans = -1;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==1) new_orange++;
                else if(grid[i][j]==2){
                    queue.add(new Node(i,j));
                    cur_old_orange++;
                }
            }
        }
        if(new_orange==0){
            return 0;
        }
        while(!queue.isEmpty()){
            Node n = queue.poll();
            int i = n.i; int j = n.j;
            cur_old_orange--;
            for(int dir = 0;dir<4;dir++){
                if(dir==0&&i-1>=0&&grid[i-1][j]==1){
                    Node o = new Node(i-1,j);
                    queue.add(o);
                    grid[i-1][j] = 2;
                    next_old_orange++;
                    new_orange--;
                }
                else if (dir==1&&j+1<grid[0].length&&grid[i][j+1]==1){
                    Node o = new Node(i,j+1);
                    queue.add(o);
                    grid[i][j+1] = 2;
                    next_old_orange++;
                    new_orange--;
                }
                else if (dir==2&&i+1<grid.length&&grid[i+1][j]==1){
                    Node o = new Node(i+1,j);
                    queue.add(o);
                    grid[i+1][j] = 2;
                    next_old_orange++;
                    new_orange--;
                }
                else if(dir==3&&j-1>=0&&grid[i][j-1]==1){
                    Node o = new Node(i,j-1);
                    queue.add(o);
                    grid[i][j-1] = 2;
                    next_old_orange++;
                    new_orange--;
                }
            }
            if(cur_old_orange==0){
                cur_old_orange = next_old_orange;
                next_old_orange = 0;
                ans++;
            }
        }
        if(new_orange<=0){
            return ans;
        }
        return -1;
    }
}
