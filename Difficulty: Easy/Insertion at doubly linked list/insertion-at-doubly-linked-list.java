/*
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}
*/

class Solution {
    Node insertAtPos(Node head, int pos, int x) {
        // code here
        if(pos<0) return head;
        
        Node newnode= new Node(x);
        
        if(pos==0){
           head.next.prev=newnode;
           newnode.next=head.next;
           newnode.prev=head;
           head.next=newnode;
           return head;
        }
        
        int count =0;
        Node temp=head;
        while(temp!=null && count<pos){
            temp=temp.next;
            count++;
        }
        
        if(count==pos){
            if(temp.next==null){
                temp.next=newnode;
                newnode.prev=temp;
            }else{
            temp.next.prev=newnode;
            newnode.next=temp.next;
            newnode.prev=temp;
            temp.next=newnode;
            }
            
        }
        
        return head;
    }
}