package leetcode.T131;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    StringBuilder sb = new StringBuilder();
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s);
        return ans;
    }

    public void dfs(String s){
        if(sb.length()==s.length()-1){
            int start = 0;
            int flag = 1;
            sb.append("1");
            StringBuilder ss = new StringBuilder(s);
            List<String> a = new ArrayList<>();
            for(int i=0;i<sb.length();i++){
                if(sb.charAt(i)=='1'){
                    a.add(ss.substring(start,i+1));
                    start = i+1;
                }
            }
            for(String s_:a){
                if(!isReverse(s_)){
                    flag = 0;
                }
            }
            if(flag==1){
                ans.add(a);
            }
            sb.deleteCharAt(sb.length()-1);
            return;
        }
        for(int i = 0;i<2;i++){
            if(i == 0){
                sb.append("0");
            }else{
                sb.append("1");
            }
            dfs(s);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public boolean isReverse(String s){
        StringBuilder sb = new StringBuilder(s);
        if(sb.reverse().toString().equals(s)){
            return true;
        }
        return false;
    }
}
