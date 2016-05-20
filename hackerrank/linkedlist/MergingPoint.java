/*
  Insert Node at the end of a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
int FindMergeNode(Node headA, Node headB) {
    // Complete this function
    // Do not write the main method. 
    Stack s1 = new Stack<Integer>();
    Stack s2 = new Stack<Integer>();
    Node t1 = headA;
    while(t1!=null){
        s1.push(t1.data);
        t1= t1.next;
    }
    t1= headB;
    while(t1!=null){
        s2.push(t1.data);
        t1= t1.next;
    }
    int i=0;
    while(!s1.isEmpty() && !s2.isEmpty() && s1.peek() == s2.peek()){
        i=(Integer)s1.pop();
        s2.pop();
    }
    return i;
}
