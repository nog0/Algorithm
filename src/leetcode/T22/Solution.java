package leetcode.T22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int cap_left;
    int remain;
    int count;
    StringBuilder sb = new StringBuilder();
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        count = n;
        cap_left = n;
        remain = 0;
        dfs();
        return ans;
    }
    public void dfs(){
        if(sb.length()==count*2){
            ans.add(sb.toString());
            return;
        }
        for(int i = 0;i<2;i++){
            if(i==0){
                if(cap_left>0){
                    sb.append("(");
                    cap_left--;
                    remain++;
                    dfs();
                    cap_left++;
                    remain--;
                    sb.deleteCharAt(sb.length()-1);
                }
            }else{
                if(remain>0){
                    sb.append(")");
                    remain--;
                    dfs();
                    remain++;
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
    }
}
