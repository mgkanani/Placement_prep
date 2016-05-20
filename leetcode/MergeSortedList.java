/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        int len,x,i,cnt,j;
        len = lists.length;
        if(len==0)
            return null;
        x=1;
        cnt=0;
        while(len>x){
            x=x<<1;
            cnt++;
        }
        for(i=0;i<cnt;i++){
            x=0;
            for(j=0;j<len;j+=2){
                if((j+1)==len){
                    lists[x]=lists[j];
                }else{
                    lists[x]=merge(lists[j],lists[j+1]);
                }
                x++;
            }
            len=x;
        }
        return lists[0];
    }
    public ListNode merge(ListNode l1, ListNode l2){
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode head,t1,t2,ht;
        t1=l1;
        t2=l2;
        if(t1.val>t2.val){
            head = t2;
            t2=t2.next;
        }else{
            head= t1;
            t1=t1.next;
        }
        ht=head;
        while(t1!=null && t2!=null){
            if(t1.val>t2.val){
                ht.next=t2;
                t2=t2.next;
            }else{
                ht.next=t1;
                t1=t1.next;
            }
            ht=ht.next;
        }
        if(t1==null){
            ht.next = t2;
        }else{
            ht.next = t1;
        }
        return head;
    }
}