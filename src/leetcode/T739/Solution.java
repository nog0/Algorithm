package leetcode.T739;

import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[temperatures.length];
        for(int i = temperatures.length-1;i>=0;i--){
            while(!s.empty()){
                int p = s.peek();
                if(temperatures[p]>temperatures[i]){
                    ans[i]=p-i;
                    s.push(i);
                    break;
                }
                s.pop();
            }
            if(s.empty()){
                s.push(i);
                ans[i] = 0;
            }
        }
        return ans;
    }
}
