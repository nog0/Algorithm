package leetcode.T56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[0]<o2[0]){
                    return -1;
                }else if(o1[0]==o2[0]){
                    if(o1[1]>o2[1]){
                        return -1;
                    }else if(o1[1]<o2[1]){
                        return 1;
                    }
                    return 0;
                }else{
                    return 1;
                }
            }
        });
        List<int[]> ans = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1;i< intervals.length;i++){
            if(intervals[i][0]==intervals[i-1][0]){
                continue;
            }
            if(intervals[i][0]<=end){
                if(intervals[i][1]>end){
                    end = intervals[i][1];
                }
                continue;
            }
            ans.add(new int[]{start,end});
            start = intervals[i][0];
            end = intervals[i][1];
        }
        ans.add(new int[]{start,end});
        return ans.toArray(new int[ans.size()][]);
    }
}
