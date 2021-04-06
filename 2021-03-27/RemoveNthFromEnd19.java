package Leetcode;

import java.util.Stack;

public class RemoveNthFromEnd19 {
  /*Method : Two pointers, Time: O(N), Space:O(1)**/
  public ListNode removeNthFromEnd3(ListNode head, int n) {
    ListNode dummy = new ListNode(0, head);
    ListNode f = head; //f从head开始， 跑n步
    ListNode s = dummy; // s从dummy开始
    for(int i = 0; i<n; i++) {
      f = f.next;
    }
    while(f!=null) {
      f = f.next;
      s = s.next;
    }
    s.next = s.next.next;
    return dummy.next;
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
