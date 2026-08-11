package leetcode.T279;

import java.util.ArrayList;

public class Solution {
    public int numSquares(int n) {
        ArrayList<Integer> pre_nums = new ArrayList<>();
        int[] ans = new int[n+1];
        for(int i = 1;i<=100;i++){
            if(i*i<=n){
                pre_nums.add(i*i);
            }else{
                break;
            }
        }
        ans[0] = 0;
        for(int i = 1;i<=n;i++){
            int cur_min = Integer.MAX_VALUE;
            for(int j :pre_nums){
                if(j>i){
                    break;
                }
                cur_min = Math.min(ans[i-j]+1,cur_min);
            }
            ans[i] = cur_min;
        }
        return ans[n];
    }
}
