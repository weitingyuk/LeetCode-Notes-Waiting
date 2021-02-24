package Leetcode;


public class PartitionList86 {
  /** Method:Iteration + two pointers, Time: O(N), Space:O(1)**/
  public ListNode partition(ListNode head, int x) {
    ListNode small = new ListNode(0);
    ListNode smallHead = small;
    ListNode large = new ListNode(0);
    ListNode largeHead = large;
    while(head != null) {
      if(head.val < x) {
        small.next = head;
        small = small.next;
      } else {
        large.next = head;
        large = large.next;
      }
      head = head.next;
    }
    large.next = null;
    small.next = largeHead.next;
    return smallHead.next;
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
