package leetcode.T152;

public class Solution {

    public static void main(String[] args) {
        new Solution().maxProduct(new int[]{2,3,-2,4});
    }
    public int maxProduct(int[] nums) {
        int[] dp_max = new int[nums.length];
        int[] dp_min = new int[nums.length];
        int ans = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            if(i==0) {
                dp_max[0] = nums[0];
                dp_min[0] = nums[0];
                ans = Math.max(ans,dp_max[i]);
                continue;
            }
            dp_max[i] = tripleMax(nums[i],nums[i]*dp_max[i-1],nums[i]*dp_min[i-1]);
            dp_min[i] = tripleMin(nums[i],nums[i]*dp_max[i-1],nums[i]*dp_min[i-1]);
            ans = Math.max(ans,dp_max[i]);
        }
        return ans;
    }

    public int tripleMax(int a,int b,int c){
        int ans = Math.max(a,b);
        ans = Math.max(ans,c);
        return ans;
    }

    public int tripleMin(int a,int b,int c){
        int ans = Math.min(a,b);
        ans = Math.min(ans,c);
        return ans;
    }
}
