/*
Reverse Nodes in k-Group

 Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5 
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RevGrpK {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<=1 || head==null || head.next==null)
            return head;
        ListNode temp = head;
        int old_k=k;
        while(k>0 && temp!=null){ temp = temp.next; k--;}
        ListNode end = null;
        if(k==0)
             end = reverseKGroup(temp,old_k);
        else
            return head;
        ListNode curr = head;
        ListNode new_head=end, t1=null;
        k=old_k;
        while(k>0){
            t1 = curr.next;
            curr.next = new_head;
            new_head = curr;
            curr = t1;
            k--;
        }
        //head.next = end;
        return new_head;
    }
}