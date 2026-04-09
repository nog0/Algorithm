package leetcode.T234;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode p = slow;
        if(slow.next!=null){
            ListNode q = p.next;
            ListNode r = q.next;
            while(q!=null){
                q.next = p;
                p = q;
                q = r;
                if(r!=null){
                    r = r.next;
                }
            }
        }
        slow.next = null;
        while(head!=null&&p!=null){
            if(head.val!=p.val){
                return false;
            }
            head = head.next;
            p = p.next;
        }
        return true;
    }
}
