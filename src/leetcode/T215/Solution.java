package leetcode.T215;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        new Solution().findKthLargest(new int[] {3,2,1,5,6,4},2);
    }
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pQ = new PriorityQueue<>();
        for(int i = 0;i<nums.length;i++){
            if(pQ.size()<k){
                pQ.add(nums[i]);
            }else{
                if(nums[i]>pQ.peek()){
                pQ.poll();
                pQ.add(nums[i]);
                }
            }
        }
        return pQ.peek();
    }
}
