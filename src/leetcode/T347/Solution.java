package leetcode.T347;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        new Solution().topKFrequent(new int[] {4,1,-1,2,-1,2,3},2);
    }

    public int[] topKFrequent(int[] nums, int k) {
        Queue<int[]> pQ = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]>o2[1]){
                    return 1;
                }else if(o1[1]<o2[1]){
                    return -1;
                }
                if(o1[0]>o2[0]){
                    return -1;
                }else if(o1[0]<o2[0]){
                    return 1;
                }
                return 0;
            }
        });
        Map<Integer,Integer> m = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            m.putIfAbsent(nums[i],0);
            m.computeIfPresent(nums[i],(key,v)->v+1);
        }
        for(Integer Key:m.keySet()){
            int[] arr = new int[2];
            arr[0] = Key;
            arr[1] = m.get(Key);
            if(pQ.size()<k){
                pQ.add(arr);
            }else{
                int[] cur = pQ.peek();
                if(arr[1]>cur[1]){
                    pQ.poll();
                    pQ.add(arr);
                }
            }
        }
        int[] ans = new int[pQ.size()];
        int count = 0;
        for(int[] item:pQ){
            ans[count] = item[0];
            count++;
        }
        return ans;
    }
}
