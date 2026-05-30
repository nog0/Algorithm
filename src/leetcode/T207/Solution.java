package leetcode.T207;

import java.util.*;

public class Solution {
    public static class Edge{
        int to;
        int next;
        public Edge(int to,int next) {
            this.to = to;
            this.next = next;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] heads = new int[10005];
        Arrays.fill(heads,-1);
        Edge[] edges = new Edge[5005];
        Queue<Integer> queue = new ArrayDeque<>();
        int last_num = numCourses;
        int[] in = new int[10005];
        for(int i=0;i<prerequisites.length;i++){
            int[] array = prerequisites[i];
            int from = array[1];
            int to = array[0];
            Edge edge = new Edge(to,heads[from]);
            edges[i] = edge;
            heads[from] = i;
            in[to]++;
        }
        for(int i=0;i<numCourses;i++){
            if(in[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()&&last_num>0){
            Integer node = queue.poll();
            last_num--;
            int cur_edge = heads[node];
            while(cur_edge!=-1){
                Edge e = edges[cur_edge];
                in[e.to]--;
                if(in[e.to]==0){
                    queue.add(e.to);
                }
                cur_edge = e.next;
            }
        }
        if(last_num>0){
            return false;
        }
        return true;
    }
}
