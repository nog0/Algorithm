package leetcode.T5;

public class Solution {
    public static void main(String[] args) {
        new Solution().longestPalindrome("abbcccba");
    }
    public String longestPalindrome(String s) {
        int num_ans = Integer.MIN_VALUE;
        String ans = "";
        int[][] dp = new int[s.length()][s.length()];
        for(int j = 0;j<s.length();j++){
            for(int i = 0;i+j<s.length();i++){
                if(j == 0){
                   dp[i][i+j] = 1;
                   if(dp[i][i+j]>num_ans){
                       num_ans = dp[i][i+j];
                       ans = s.substring(i,i+j+1);
                   }
                   continue;
                }
                boolean b = s.charAt(i) == s.charAt(i + j);
                if(j==1){
                    dp[i][i+j] = b ? 2 : 0;
                    if(dp[i][i+j]>num_ans){
                        num_ans = dp[i][i+j];
                        ans = s.substring(i,i+j+1);
                    }
                    continue;
                }
                if(!b||dp[i+1][i+j-1]==0){
                    dp[i][i+j] = 0;
                    continue;
                }
                dp[i][i+j] = dp[i+1][i+j-1]+2;
                if(dp[i][i+j]>num_ans){
                    num_ans = dp[i][i+j];
                    ans = s.substring(i,i+j+1);
                }
            }
        }
        return ans;
    }
}
