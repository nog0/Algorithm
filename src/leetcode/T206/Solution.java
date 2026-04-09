package leetcode.T206;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        if (head==null || head.next == null){
            return head;
        }
        ListNode p = head;
        ListNode q = head.next;
        ListNode r = q.next;
        p.next = null;
        while(q!=null){
            q.next = p;
            p = q;
            q = r;
            if(r!=null){
                r = r.next;
            }
        }
        return p;
    }
}
