package leetcode.T46;

import java.util.*;

public class Solution {
    boolean[] flags;
    List<List<Integer>> ans;
    Deque<Integer> queue = new ArrayDeque<>();
    public List<List<Integer>> permute(int[] nums) {
        flags = new boolean[nums.length];
        ans = new ArrayList<>();
        addList(nums);
        return ans;
    }

    public void addList(int[] nums) {
        if(queue.size()==nums.length){
            ans.add(new ArrayList<>(queue));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(!flags[i]){
                flags[i] = true;
                queue.push(nums[i]);
                addList(nums);
                flags[i] = false;
                queue.pop();
            }
        }
    }
}
