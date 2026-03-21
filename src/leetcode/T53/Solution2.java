package leetcode.T53;

public class Solution2 {
    public int maxSubArray(int[] nums) {
        return findMaxSubArray(nums,0,nums.length)[2];
    }

    public int[] findMaxSubArray(int[] nums,int start,int end){
        if(end-start<=1){
            return new int[]{start,end,nums[start]};
        }
        int[] left = findMaxSubArray(nums,start,(start+end)/2);
        int[] right = findMaxSubArray(nums,(start+end)/2,end);
        int left_max = nums[(start+end)/2-1];
        int right_max = nums[(start+end)/2];
        int position_left = (start+end)/2-1;
        int position_right = (start+end)/2+1;
        int sum = 0;
        for(int i = (start+end)/2-1;i>=start;i--){
            sum+=nums[i];
            if(sum>left_max){
                left_max = sum;
                position_left = i;
            }
        }
        sum = 0;
        for(int i = (start+end)/2;i<end;i++){
            sum+=nums[i];
            if(sum>right_max){
                right_max = sum;
                position_right = i+1;
            }
        }
        int max = left_max+right_max;
        if (max>left[2]&&max>right[2]){
            return new int[]{position_left,position_right,max};
        }
        else{
            if(left[2]>right[2]){
                return left;
            }else{
                return right;
            }
        }
    }
}
