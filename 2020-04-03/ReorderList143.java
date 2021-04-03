package Leetcode;

import Leetcode.RemoveNthFromEnd19.ListNode;

public class ReorderList143 {

  /**Method: reverse mid, then mergep; Time: O(N);  Space:O(1)**/
  public void reorderList(ListNode head) {
    if(head == null) {
      return;
    }
    ListNode mid = getMid(head); // 1. 获取mid
    ListNode l1 = head;
    ListNode l2 = mid.next;
    mid.next= null;

    l2 = reverseList(l2); // 2. reverse l2
    merge(l1, l2); //3. merge l1 & l2 (不是大小合并，而是逐个合并两个链表)
  }

  private void merge(ListNode l1, ListNode l2){
    ListNode t1;
    ListNode t2;
    while(l1 != null & l2!=null) {
      t1 = l1.next;
      t2 = l2.next;

      l1.next =l2;
      l1 = t1;

      l2.next = l1;
      l2 = t2;
    }
  }

  private ListNode getMid(ListNode head) {
    ListNode s = head, f = head;
    while(f.next != null && f.next.next != null) {
      s = s.next;
      f = f.next.next;
    }
    return s;
  }

  private ListNode reverseList(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    while(cur != null) {
      ListNode np = cur.next;
      cur.next = pre;
      pre = cur;
      cur = np;
    }
    return pre;
  }
}
