public class Rev_LinkedList {
    /*
    Reverse a singly linked list. Recursive.
    */
    ListNode new_head;// = null;//new ListNode(0);
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        head = process(head);
        head.next=null;
        return new_head;
    }
    public ListNode process(ListNode head) {
        if(head.next==null){
            new_head = head;
            return head;
        }else{
            ListNode temp = process(head.next);
            temp.next = head;
            return head;
        }
    }
}