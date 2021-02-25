package Leetcode;

public class DetectCycle142 {
  /*Method : Two pointers, Time: O(N), Space:O(1)**/
  public ListNode detectCycle(ListNode head) {
    if(head == null || head.next ==null){
      return null;
    }
    ListNode slow = head;
    ListNode fast = slow.next;
    while(slow != fast) {
      if(fast == null || fast.next == null) {
        return null;
      }
      slow = slow.next;
      fast = fast.next.next;
    }

    slow = head;
    fast = fast.next;
    while(slow != fast) {
      slow =slow.next;
      fast =fast.next;
    }
    return slow;
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
