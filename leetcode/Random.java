/**
 * Definition for singly-linked list with a random pointer.
 */
 import java.util.*;
 class RandomListNode {
     int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
 };
 
public class Random {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)
            return head;
        RandomListNode newhead=null,t1=head,t2=null;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        while(t1!=null){
            if(newhead==null){
                newhead = new RandomListNode(t1.label);
                newhead.next=null;
                t2=newhead;
                //newhead.random=null;
            }else{
                t2.next = new RandomListNode(t1.label);
                t2=t2.next;
                t2.next=null;
            }
            map.put(t1,t2);
            t1=t1.next;
        }
        t2=newhead;
        t1=head;
        while(t1!=null){
            if(map.containsKey(t1.random))
                t2.random = map.get(t1.random);
            else
                t2.random = null;
            t2=t2.next;
            t1=t1.next;
        }
        return newhead;
    }
}
