package leetcode.T128;

import java.util.HashMap;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int max_length = 1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(!map.containsKey(nums[i])) {
                map.put(nums[i],null);
            }
        }
        for (int num : nums) {
            Integer a = map.get(num);
            if (a != null) {
                continue;
            }
            map.put(num, 1);
            for (int j = num + 1; j < num + nums.length; j++) {
                if (!map.containsKey(j)) {
                    if (map.get(num) > max_length) {
                        max_length = map.get(num);
                    }
                    break;
                }
                Integer b = map.get(j);
                if (b != null) {
                    map.compute(num, (k, v) -> v = v + b);
                    if (map.get(num) > max_length) {
                        max_length = map.get(num);
                    }
                    break;
                } else {
                    map.put(j, 0);
                    map.compute(num, (k, v) -> v = v + 1);
                    if (map.get(num) > max_length) {
                        max_length = map.get(num);
                    }
                }
            }
        }
        return max_length;
    }
}
