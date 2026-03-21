package leetcode.T53;

public class Solution1 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int[] f = new int[nums.length];
        f[0] = nums[0];
        for(int i =1;i<nums.length;i++){
            f[i] = Math.max(nums[i],nums[i]+f[i-1]);
            if (max<f[i]){
                max = f[i];
            }
        }
        return max;
    }
}
