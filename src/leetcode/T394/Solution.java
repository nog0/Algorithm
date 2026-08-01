package leetcode.T394;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) {
        new Solution().decodeString("2[abc]3[cd]ef");
    }

    public String decodeString(String s) {
        Deque<Character> c_deque = new ArrayDeque<>();
        Deque<StringBuilder> s_deque = new ArrayDeque<>();
        Deque<Integer> i_deque = new ArrayDeque<>();
        StringBuilder int_s = new StringBuilder();
        for(int i =0;i<s.length();i++){
            Character ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int_s.append(ch);
            }else{
                if(int_s.length()>0){
                    i_deque.push(Integer.parseInt(int_s.toString()));
                    int_s.delete(0,int_s.length());
                }
                if(ch =='['){
                    c_deque.push(ch);
                }else if(Character.isAlphabetic(ch)){
                    c_deque.push(ch);
                }else{
                    StringBuilder ss = new StringBuilder();
                    StringBuilder s_result = new StringBuilder();
                    while((ch = c_deque.pop())!='['){
                        ss.append(ch);
                    }
                    for(int j = 0 ; j<ss.length();j++){
                        char c  = ss.charAt(j);
                        if(c=='$'){
                            s_result.append(s_deque.pop().reverse());
                        }else{
                            s_result.append(c);
                        }
                    }
                    int count = i_deque.pop();
                    s_result.reverse();
                    String temp = s_result.toString();
                    for(int j = 0 ;j<count-1;j++){
                        s_result.append(temp);
                    }
                    s_deque.push(s_result);
                    c_deque.push('$');
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!c_deque.isEmpty()){
            char ch = c_deque.pop();
            if(ch=='$'){
                ans.append(s_deque.pop().reverse());
            }else{
                ans.append(ch);
            }
        }
        return ans.reverse().toString();
    }
}
