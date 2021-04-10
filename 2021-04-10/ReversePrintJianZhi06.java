package Leetcode;

import Leetcode.RemoveNthFromEnd19.ListNode;

public class ReversePrintJianZhi06 {
  /*Method1: recur, Time: O(N), Space:O(N)**/
  public int[] reversePrint(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    int size = 0;
    while(cur != null) {
      ListNode np = cur.next;
      cur.next = pre;
      pre =cur;
      cur = np;
      size ++;
    }
    cur = pre;
    int[] res = new int[size];
    for(int i=0;i<size;i++) {
      res[i] = cur.val;
      cur = cur.next;
    }
    return res;
  }

}
