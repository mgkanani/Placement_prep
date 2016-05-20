import java.util.*;
/*
Merge k Sorted Lists
Using Heap / Priority Queue.

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity. 
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class MergeSortedList_heap{
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> que = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode p1, ListNode p2){
                return p1.val-p2.val;
            }
        });
        for(ListNode node:lists){
            if(node!=null)
                que.add(node);
        }
        ListNode head = null;
        ListNode curr = null,temp=null;
        while(!que.isEmpty()){
            temp = que.poll();
            if(temp!=null){
                if(head==null){
                    curr=temp;
                    head=temp;
                }else{
                    curr.next=temp;
                    curr = curr.next;
                }
                if(temp.next!=null)
                    que.add(temp.next);
            }
        }
        return head;
    }
}