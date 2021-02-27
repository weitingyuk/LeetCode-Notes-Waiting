package Leetcode;


public class GetIntersectionNode160 {
  /*Method : Two pointers, Time: O(N + M), Space:O(1)**/
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if(headA == null || headB == null) {
      return null;
    }
    ListNode curA = headA;
    ListNode curB = headB;
    while(curA != curB) {
      curA = curA == null ? headB : curA.next;
      curB = curB == null ? headA : curB.next;
    }
    return curB;
  }

  //Definition for singly-linked list.
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
