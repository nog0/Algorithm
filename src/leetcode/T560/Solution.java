package leetcode.T560;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
* arr[i] - arr[j-1] = k [j...i]
* arr[j-1] = arr[i] - k
* */

public class Solution {
    public int subarraySum(int[] nums, int k) {
        List<Integer> pre = new ArrayList<>();
        int ans = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int sum = 0;
        for(int i =0;i<nums.length;i++){
            sum+=nums[i];
            pre.add(sum);
        }
        if(pre.get(0)==k){
            ans++;
        }
        hashMap.put(pre.get(0),1);
        for(int i=1;i<nums.length;i++){
            if(pre.get(i)==k){
                ans++;
            }
            Integer a = hashMap.get(pre.get(i)-k);
            if(a!=null){
                ans+=a;
            }
            hashMap.computeIfAbsent(pre.get(i),v->0);
            hashMap.compute(pre.get(i),(key,v)->v+1 );
        }
        return ans;
    }
}
