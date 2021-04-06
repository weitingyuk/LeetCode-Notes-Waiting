package Leetcode;

import Leetcode.RemoveNthFromEnd19.ListNode;

public class MiddleNode876 {
  /** Method:Two pointers, Time: O(N), Space:O(1)**/
  public ListNode middleNode(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

}
