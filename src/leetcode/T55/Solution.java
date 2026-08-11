package leetcode.T55;

public class Solution {
    public boolean canJump(int[] nums) {
        int flag = 0;
        int need = 0;
        for(int i = nums.length-2;i>=0;i--){
            if(flag==0&&nums[i]>0){
                continue;
            }
            if(flag==0&&nums[i]==0){
                need+=1;
                flag = 1;
                continue;
            }
            if(nums[i]>need){
                flag = 0;
                need = 0;
                continue;
            }
            need++;
        }
        return flag != 1;
    }
}
