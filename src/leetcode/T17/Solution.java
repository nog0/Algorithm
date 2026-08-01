package leetcode.T17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<Integer,String> map = new HashMap<>();
    List<String> ans = new ArrayList<>();
    StringBuilder s = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        dfs(digits,0);
        return ans;
    }

    public void dfs(String digits,int k) {
        if(k==digits.length()){
            ans.add(s.toString());
            return;
        }
        char c = digits.charAt(k);
        String cur = map.get(c-'0');
        for(int i = 0;i<cur.length();i++){
            s.append(cur.charAt(i));
            dfs(digits,k+1);
            s.deleteCharAt(s.length()-1);
        }
    }
}
