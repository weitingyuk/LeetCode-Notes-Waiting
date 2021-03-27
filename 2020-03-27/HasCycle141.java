package Leetcode;


public class HasCycle141 {
  /*Method : Two pointers, Time: O(N), Space:O(1)**/
  public boolean hasCycle(ListNode head) {
    if(head == null ||head.next ==null) {
      return false;
    }
    ListNode s = head;
    ListNode f = head.next;
    while(s != f) {
      if(f== null || f.next == null) {
        return false;
      }
      s = s.next;
      f = f.next.next;
    }
    return true;
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
