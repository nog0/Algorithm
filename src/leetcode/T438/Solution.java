package leetcode.T438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        new Solution().findAnagrams("abab","ab");
    }
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> cMap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i =0 ;i<p.length();i++){
            cMap.computeIfAbsent(p.charAt(i),v->0);
            cMap.put(p.charAt(i),cMap.get(p.charAt(i))+1);
        }
        int l = 0, r = 0;
        while(r<s.length()){
            if(!cMap.containsKey(s.charAt(r))){
                r++;
                while(l<r){
                    if(cMap.containsKey(s.charAt(l))){
                        cMap.compute(s.charAt(l),(k,v)->v+1);
                    }
                    l++;
                }
                continue;
            }
            int a = cMap.get(s.charAt(r));
            if(a<=0){
                cMap.compute(s.charAt(l),(k,v)->v+1);
                l++;
                continue;
            }
            cMap.compute(s.charAt(r),(k,v)->v-1);
            r++;
            if(r-l==p.length()){
                ans.add(l);
            }
        }
        return ans;
    }
}