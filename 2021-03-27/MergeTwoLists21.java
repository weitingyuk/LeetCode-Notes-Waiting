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
    ListNode dummy = new ListNode(-1);
    ListNode pre = dummy;
    while(l1 != null && l2 != null) {
      if(l1.val < l2.val) {
        pre.next = l1;
        l1 = l1.next;
      } else {
        pre.next = l2;
        l2 = l2.next;
      }
      pre = pre.next;
    }
    pre.next = l1 == null? l2: l1;
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
