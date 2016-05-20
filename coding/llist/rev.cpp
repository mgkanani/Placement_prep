#include <iostream>
#include <cstdio>
#include <cstdlib>

using namespace std;

/*
https://leetcode.com/problems/reverse-linked-list-ii/

Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list. 
*/


struct ListNode
{
	int data;
	ListNode *next;
};
/*
  Print elements of a linked list on console 
  head pointer input could be NULL as well for empty list
  ListNode is defined as 
  struct Node
  {
     int data;
     struct ListNode *next;
  }
*/
void Print(ListNode *head)
{
  // This is a "method-only" submission. 
  // You only need to complete this method. 
    struct ListNode *temp=head;
    if(temp==NULL)
        temp=temp->next;
    while(temp!=NULL){
      cout<<temp->data<<endl;
      temp=temp->next;
    };
}

void Free(ListNode *head)
{
  // This is a "method-only" submission. 
  // You only need to complete this method. 
    struct ListNode *temp=head;
    struct ListNode *temp1=head;
    while(temp!=NULL){
      temp=temp->next;
      delete temp1;
      temp1=temp;
    };
}


ListNode* Insert(ListNode *head,int x)
{
   ListNode *temp = new ListNode();
   temp->data = x;
   temp->next = NULL;
   if(head == NULL) 
   {
       return temp;
   }
   ListNode *temp1;
   for(temp1 = head;temp1->next!=NULL;temp1= temp1->next);
   temp1->next = temp;return head;
}


struct ListNode* reverseBetween(struct ListNode* head, int m, int n) {

	int N=m;
	ListNode *pred=head,*last=NULL,*cur=head,*temp=head;
	if(m==n)
		return head;
	while(m>1){
//      		cout<<temp->data<<endl;
		pred=temp;
		temp=temp->next;
		--n;
		--m;
		cur=temp;
	}
	while(n>0){
      		cout<<temp->data<<endl;
		temp = temp->next;
		cur->next=last;
		last= cur;
		cur = temp;
		if(n==1){
			if(N==1){
      				//cout<<"h"<<endl;
				head = last;
				pred->next = temp;
			}else{
				pred->next->next = temp;
				pred->next = last;
			}
		}
		--n;
	}
	return head;
}

int main()
{
	int t;
	cin>>t;
	while(t-- >0)
	{
               
		int x; cin>>x;
		 ListNode *head = NULL;
                while(x--)
                {
					 
                    int y;cin>>y;
		           head = Insert(head,y);
                }
		head=reverseBetween(head,1,2);
           	Print(head);
		Free(head);
	}

}

struct ListNode* reverseList(struct ListNode* head) {

    struct ListNode *temp=head, *first=head, *rem=NULL;

    if(head == NULL)

        return head;

    temp = head->next;

    first->next = NULL:

    while(temp != NULL){

        rem = first;

        first = temp;

        temp = temp->next;

        first->next = rem;

    }

    return first;

}
