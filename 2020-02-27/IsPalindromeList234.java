package Leetcode;

public class IsPalindromeList234 {
  /*Method : Two pointers, Time: O(N), Space:O(1)**/
  public boolean isPalindrome(ListNode head) {
    if(head == null) {
      return true;
    }
    ListNode fistHalfEnd = getEndOfFirstHalf(head);
    ListNode secondHalfStart = reverseList(fistHalfEnd.next);
    ListNode curFirst = head;
    ListNode curSecond = secondHalfStart;
    boolean result = true;
    while (result && curSecond != null ) {
      if(curFirst.val != curSecond.val) {
        result = false;
      }
      curFirst = curFirst.next;
      curSecond = curSecond.next;
    }
    fistHalfEnd.next = reverseList(secondHalfStart);
    return result;
  }
  private ListNode reverseList(ListNode head) {
    ListNode cur = head;
    ListNode pre = null;
    while (cur != null) {
      ListNode temp = cur.next;
      cur.next = pre;
      pre = cur;
      cur =temp;
    }
    return pre;
  }
  private ListNode getEndOfFirstHalf(ListNode head) {
    ListNode first = head;
    ListNode second = head;
    while(second.next != null && second.next.next != null) {
      first = first.next;
      second =second.next.next;
    }
    return first;
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
