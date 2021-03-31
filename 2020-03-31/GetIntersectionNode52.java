package Leetcode;


import Leetcode.RemoveNthFromEnd19.ListNode;

public class GetIntersectionNode52 {
  /*Method: Two pointers, Time: O(N+M), Space:O(1)**/
  /**
   链表1的长度 = x + z;
   链表2的长度 = y + z;
   所以x+z+y = y+z+x
   **/
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode l1 = headA;
    ListNode l2 = headB;
    while(l1 != l2) {
      l1 = l1 == null? headB: l1.next; //注意这里是l1 == null，不是l1.next
      l2 = l2 == null? headA: l2.next;
    }
    return l1;
  }


}
