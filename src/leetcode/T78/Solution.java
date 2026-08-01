package leetcode.T78;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    public List<List<Integer>> subsets(int[] nums) {
        for(int k = 0;k<=nums.length;k++){
            addNList(k,-1,nums);
        }
        return ans;
    }

    public void addNList(int k,int start,int[] nums){
        if(k==0){
            ans.add(new ArrayList<>(set));
            return;
        }
        for(int i = start+1;i<=nums.length-k;i++){
            set.add(nums[i]);
            addNList(k-1,i,nums);
            set.remove(nums[i]);
        }
    }
}
