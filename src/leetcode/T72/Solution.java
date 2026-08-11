package leetcode.T72;

public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.isEmpty()){
            return word2.length();
        }
        if(word2.isEmpty()){
            return word1.length();
        }
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i = 0;i<word1.length()+1;i++){
            for(int j = 0;j<word2.length()+1;j++){
                if(i==0&&j==0){
                    dp[0][0] = 0;
                    continue;
                }
                if(i==0){
                    dp[i][j] = dp[i][j-1] + 1;
                    continue;
                }
                if(j==0){
                    dp[i][j] = dp[i-1][j] + 1;
                    continue;
                }
                int delete = dp[i-1][j]+1;
                int add = dp[i][j-1]+1;
                int change = word1.charAt(i-1)==word2.charAt(j-1) ? dp[i-1][j-1] : dp[i-1][j-1] + 1;
                dp[i][j] = tripleMin(delete,add,change);
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public int tripleMin(int a, int b ,int c){
        int ans = Math.min(a,b);
        ans = Math.min(ans,c);
        return ans;
    }
}
