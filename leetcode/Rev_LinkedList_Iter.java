 public class Rev_LinkedList_Iter {
    /*
    Reverse a singly linked list. Iterative.
    */
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode curr=head;
        ListNode temp=head;
        ListNode new_head=null;
        while(curr!=null){
            temp = curr.next;
            curr.next = new_head;
            new_head = curr;
            curr = temp;
        }
        return new_head;
    }
}