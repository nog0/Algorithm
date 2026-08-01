package leetcode.T169;

public class Solution {
    public int majorityElement(int[] nums) {
        int sum = 0;
        int now = nums[0];
        int flag = 0;
        for (int num : nums) {
            if (flag == 0) {
                now = num;
                flag = 1;
            }
            if (now == num) {
                sum++;
            } else {
                sum--;
            }
            if (sum == 0) {
                flag = 0;
            }
        }
        return now;
    }
}
