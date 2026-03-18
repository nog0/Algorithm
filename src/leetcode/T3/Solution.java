package leetcode.T3;

import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0,r = 0;
        int max_length = 0;
        HashSet<Character> set = new HashSet<>();
        while(r<s.length()){
            if (set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
                continue;
            }
            set.add(s.charAt(r));
            r++;
            if((r-l)>max_length){
                max_length = r-l;
            }
        }
        return max_length;
    }
}
