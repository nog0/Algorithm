package leetcode.T24;
import java.lang.Math;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode front = null;
        ListNode p = head;
        ListNode q = p.next;
        while(p!=null&&q!=null){
            p.next = q.next;
            q.next = p;
            if(front!=null){
                front.next = q;
            }
            front = p;
            if(p==head){
                head = q;
            }
            p = p.next;
            if(p!=null){
                q = p.next;
            }
        }
        return head;
    }
}
