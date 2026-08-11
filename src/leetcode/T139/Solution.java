package leetcode.T139;

import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] isOk = new boolean[s.length()+1];
        isOk[0] = true;
        for(int i =1;i<=s.length();i++){
            boolean cur = false;
            for(String word:wordDict){
                if(i<word.length()){
                    continue;
                }
                if(!s.startsWith(word, i-word.length())){
                    continue;
                }
                if(isOk[i - word.length()]){
                    cur=true;
                    break;
                }
            }
            isOk[i]=cur;
        }
        return isOk[s.length()];
    }
}
