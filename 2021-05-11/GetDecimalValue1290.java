package Leetcode;

import Leetcode.AddTwoNumbers2.ListNode;

public class GetDecimalValue1290 {
  /*Method: Mock, Time: O(N), Space:O(1)**/
  public int getDecimalValue(ListNode head) {
    ListNode cur = head;
    int res = 0;
    while(cur != null) {
      res = cur.val + res * 2;
      cur = cur.next;
    }
    return res;
  }

}
