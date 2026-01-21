/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    Node reverseList(Node head) {
        // code here
        if(head==null || head.next==null) return head;
        
        Node prev=null;
        Node cur = head;
       
        
        while(cur!=null){
            Node next = cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
}