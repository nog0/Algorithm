package leetcode.T141;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        if(p == null || p.next==null){
            return false;
        }
        do {
            p = p.next;
            q = q.next.next;
        } while(q!=null && q.next!=null && p!=q);
        return p == q;
    }
}
