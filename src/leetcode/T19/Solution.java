package leetcode.T19;

import java.util.Stack;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        ListNode phead = new ListNode(-1);
        phead.next = head;
        ListNode p = phead;
        while(p!=null){
            stack.add(p);
            p = p.next;
        }
        while(n!=0){
            n--;
            ListNode a = stack.pop();
            if(n==0){
                ListNode b = stack.pop();
                b.next = a.next;
                break;
            }
        }
        return phead.next;
    }
}
