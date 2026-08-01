package leetcode.T34;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int right = -1;
        int left = -1;
        int l=0,r = nums.length;
        while(l<r){
            int t = nums[(l+r)/2];
            if(t>target){
                r= (l+r)/2;
            }else{
                if(target == nums[(l+r)/2]){
                    right = (l+r)/2;
                }
                l = (l+r)/2+1;
            }
        }
        l = 0;r = nums.length;
        while(l<r){
            int t = nums[(l+r)/2];
            if(t<target){
                l = (l+r)/2+1;
            }else{
                if(target == nums[(l+r)/2]){
                    left = (l+r)/2;
                }
                r= (l+r)/2;
            }
        }
        int[] ans = new int[2];
        ans[0]=left;ans[1]=right;
        return ans;
    }
}
