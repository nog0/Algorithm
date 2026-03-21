package leetcode.T238;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        right[nums.length-1] = 1;
        for(int i=1;i<left.length;i++){
            left[i] = left[i-1]*nums[i-1];
        }
        for(int i= right.length-2;i>=0;i--){
            right[i] = right[i+1]*nums[i+1];
        }
        int[] answers = new int[nums.length];
        for(int i=0;i<answers.length;i++){
            answers[i] = left[i]*right[i];
        }
        return answers;
    }
}
