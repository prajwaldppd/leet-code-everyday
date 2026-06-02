/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middlenode(ListNode head){
        ListNode slow = head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode cur = head;
        ListNode prev = null;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next=prev;
            prev = cur;
            cur=next;
        }
        return prev;

    }
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode mid = middlenode(head);
        ListNode secondHalf = reverse(mid.next);
        mid.next = null;  
        ListNode firstHalf = head;
        while (firstHalf != null && secondHalf != null) {
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = temp1;

            firstHalf = temp1;
            secondHalf = temp2;
        }
    }
}