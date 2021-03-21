package Leetcode;

public class AddTwoNumbers2 {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry=0;
    int cur = 0;
    ListNode dummy = new ListNode(-1);
    ListNode node = dummy;
    while(l1!=null || l2!=null || carry != 0) {
      int x = l1 == null ? 0 : l1.val;
      int y= l2== null ? 0 : l2.val;
      cur =x+y+carry;
      carry = cur/10;
      ListNode nextp = new ListNode(cur % 10);
      node.next = nextp;
      node = nextp;
      if(l1!=null) {
        l1=l1.next;
      }
      if(l2!=null) {
        l2=l2.next;
      }
    }
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
