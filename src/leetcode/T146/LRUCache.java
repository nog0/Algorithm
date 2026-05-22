package leetcode.T146;


import java.util.HashMap;

public class LRUCache {
    static class ListNode {
        ListNode front;
        int val;
        ListNode next;
        int key;
        public ListNode(ListNode front,int key,int val, ListNode next){
            this.front = front;
            this.val = val;
            this.key = key;
            this.next = next;
        }
    }
    int capacity;
    ListNode head;
    ListNode tail;
    HashMap<Integer,ListNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new ListNode(null,-1,-1,null);
        this.tail = head;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        ListNode t= map.get(key);
        if(t.front==this.head){
            return t.val;
        }
        if(t == this.tail){
            this.tail = t.front;
            this.tail.next = null;
        }
        else{
            t.front.next = t.next;
            t.next.front = t.front;
        }
        t.front = this.head;
        t.next = this.head.next;
        this.head.next = t;
        t.next.front = t;
        return t.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            ListNode t = map.get(key);
            if(t.front==this.head){
                t.val = value;
                return;
            }
            if(t == this.tail){
                this.tail = t.front;
                this.tail.next = null;
            }
            else{
                t.front.next = t.next;
                t.next.front = t.front;
            }
            t.front = this.head;
            t.next = this.head.next;
            this.head.next = t;
            t.next.front = t;
            t.val = value;
            return;
        }
        if(this.capacity>0){
            this.capacity--;
            ListNode t = new ListNode(this.head,key,value,this.head.next);
            map.put(key,t);
            if(this.tail==this.head){
                this.tail = t;
                this.head.next = t;
                return;
            }
            this.head.next.front = t;
            this.head.next = t;
            return;
        }
        int tail_key = this.tail.key;
        map.remove(tail_key);
        if(this.tail.front==this.head){
            this.tail =  new ListNode(this.head,key,value,null);
            this.head.next = tail;
            map.put(key,this.tail);
            return;
        }
        ListNode t = new ListNode(this.head,key,value,this.head.next);
        this.tail = this.tail.front;
        this.tail.next = null;
        this.head.next = t;
        t.next.front = t;
        map.put(key,t);
    }
}
