package leetcode.T300;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        new Solution().lengthOfLIS(new int[]{4,10,4,3,8,9});
    }
    public int lengthOfLIS(int[] nums) {
        int[] ans = new int[nums.length+1];
        int a = 0;
        for(int i = 0 ;i<nums.length;i++){
            if(i==0){
                ans[1] = nums[i];
                a++;
                continue;
            }
            if(nums[i]>ans[a]){
                a++;
                ans[a] = nums[i];
                continue;
            }
            int pos = binarySearch(ans,nums[i],1,a+1);
            ans[pos] = nums[i];
        }
        return a;
    }

    public int binarySearch(int[] ans,int num, int start,int end){
        if(num<ans[start]){
            return start;
        }
        if(num>ans[end-1]){
            return end;
        }
        while(end>start){
            int mid = (end+start) / 2;
            if(ans[mid]<num){
                start = mid + 1;
            }else if(ans[mid]>num){
                if(ans[mid-1]<num){
                    return mid;
                }else{
                    end = mid;
                }
            }else{
                return mid;
            }
        }
        return end-1;
    }
}
