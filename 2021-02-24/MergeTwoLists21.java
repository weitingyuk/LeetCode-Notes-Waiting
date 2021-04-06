package Leetcode;


public class MergeTwoLists21 {
  /** Method 1:Recursion, Time: O(N+M), Space:O(N+M)**/
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 == null) {
      return l2;
    } else if(l2 == null) {
      return l1;
    } else if(l1.val < l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }
  }

  /** Method 2:Iteration + Dummy Node, Time: O(N+M), Space:O(N+M)**/
  public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode pre = dummy;
    ListNode cur1 = l1;
    ListNode cur2 = l2;
    while (cur1 != null && cur2 != null) {
      if(cur1.val < cur2.val) {
        pre.next = cur1;
        cur1 = cur1.next;
      } else {
        pre.next = cur2;
        cur2 = cur2.next;
      }
      pre = pre.next;
    }
    pre.next = cur1 == null ? cur2 : cur1;
    return dummy.next;
  }

  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
