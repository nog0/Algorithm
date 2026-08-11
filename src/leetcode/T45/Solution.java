package leetcode.T45;

public class Solution {
    public static void main(String[] args) {
        new Solution().jump(new int[]{1,2,3});
    }
    public int jump(int[] nums) {
        int ans = 1;
        int i = 0;
        int border = nums[0];
        if(nums.length==1){
            return 0;
        }
        while(border<nums.length-1){
            int next_s = 0;
            for(int j = 1;j<=nums[i];j++){
                if(i+j+nums[i+j]>border){
                    border = i+j+nums[i+j];
                    next_s = i+j;
                }
            }
            i = next_s;
            ans++;
        }
        return ans;
    }
}
