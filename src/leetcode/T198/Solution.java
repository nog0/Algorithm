package leetcode.T198;

public class Solution {
    public int rob(int[] nums) {
        int[] max_arr = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            if(i==0||i==1){
                max_arr[i] = nums[i];
                continue;
            }
            int max=-1;
            for(int j = 0;j<i-1;j++){
                if(max<nums[i]+max_arr[j]){
                    max = nums[i]+max_arr[j];
                }
            }
            max_arr[i] = max;
        }
        if(nums.length==1){
            return nums[0];
        }
        return Math.max(max_arr[nums.length - 1], max_arr[nums.length - 2]);
    }
}
