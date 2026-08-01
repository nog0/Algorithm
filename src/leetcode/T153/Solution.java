package leetcode.T153;

public class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length;
        int ans = Integer.MAX_VALUE;
        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid]<ans){
                ans = nums[mid];
            }
            if(mid>l&&nums[l]<=nums[mid-1]){
                if (nums[l]<ans){
                    ans = nums[l];
                }
                l = mid+1;
            }else if(mid<r-1){
                if(nums[mid+1]<ans){
                    ans = nums[mid+1];
                }
                r = mid;
            }else{
                return ans;
            }
        }
        return ans;
    }
}
