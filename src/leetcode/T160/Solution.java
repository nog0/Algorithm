package leetcode.T160;



public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public int getListLength(ListNode head){
        int i=0;
        ListNode phead = new ListNode(-1);
        phead.next = head;
        ListNode p = phead;
        while(p.next!=null){
            p = p.next;
            i++;
        }
        return  i;
    }

    public ListNode findNodeByIndex(ListNode head,int index){
        ListNode phead = new ListNode(-1);
        phead.next = head;
        ListNode p = phead;
        while(index>0&&p.next!=null){
            index--;
            p = p.next;
        }
        return p;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a = getListLength(headA);
        int b = getListLength(headB);
        int c = a>b ? a-b : b-a;
        ListNode r = a>b ? headA : headB;
        ListNode p = findNodeByIndex(r,c);
        p = p.next;
        ListNode q = a>b ? headB : headA;
        while(p!=null&&q!=null&&p!=q){
            p = p.next;
            q = q.next;
        }
        return p;
    }
}

