package leetcode.T322;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] ans = new int[amount+1];
        ans[0] = 0;
        for(int i = 1;i<=amount;i++){
            int cur_min = Integer.MAX_VALUE;
            int flag = 0;
            for(int j = 0;j<coins.length;j++){
                if(coins[j]>i){
                    continue;
                }
                if(ans[i-coins[j]]==-1){
                    continue;
                }
                cur_min = Math.min(cur_min,ans[i-coins[j]]+1);
                flag=1;
            }
            if(flag==0){
                ans[i] = -1;
            }else{
                ans[i] = cur_min;
            }
        }
        return ans[amount];
    }
}
