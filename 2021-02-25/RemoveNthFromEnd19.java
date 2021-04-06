package Leetcode;

import java.util.Stack;

public class RemoveNthFromEnd19 {
  /*Method 1: Compute the length of list, Time: O(N), Space:O(1)**/
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0, head);
    ListNode cur = dummy;
    int len = getLength(head);
    for(int i = 1 ;i < len - n + 1; i++) {
      cur = cur.next;
    }
    cur.next = cur.next.next;
    return dummy.next;
  }

  private int getLength(ListNode head) {
    int count = 0;
    while(head != null) {
      count ++;
      head = head.next;
    }
    return count;
  }

  /** Method 2: Stack(push & pop) + dummy, Time: O(Len), Space:O(Len)**/
  public ListNode removeNthFromEnd2(ListNode head, int n) {
    Stack<ListNode> stack = new Stack();

    ListNode dummy = new ListNode(0, head);
    ListNode cur = dummy;
    while(cur != null) {
      stack.push(cur);
      cur = cur.next;
    }
    for(int i =0 ;i< n; i++) {
      stack.pop();
    }
    ListNode prev = stack.pop();
    prev.next = prev.next.next;
    return dummy.next;
  }

  /*Method 3: Two pointers, Time: O(N), Space:O(1)**/
  public ListNode removeNthFromEnd3(ListNode head, int n) {
    ListNode dummy = new ListNode(0, head);
    ListNode fast = head;
    ListNode slow = dummy;
    for(int i=0; i< n; i++) {
      fast = fast.next;
    }
    while (fast!=null) {
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
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
