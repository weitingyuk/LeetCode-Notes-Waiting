package Leetcode;


public class MergeKLists23 {
  /*Method 1: Sequential merge, Time: O(NK^2), Space:O(1) ; K is the number of list**/
  public ListNode mergeKLists1(ListNode[] lists) {
    if(lists.length == 0) {
      return null;
    }
    ListNode res = null;
    for(int i =0;i< lists.length; i++) {
      res = mergeTwoLists(res, lists[i]);
    }
    return res;
  }

  /*Method 2: Divide and conquer, Time: O(NKLog(K)), Space:O(Log(K)); K is the number of list**/
  public ListNode mergeKLists2(ListNode[] lists) {
    return merge(lists, 0, lists.length-1);
  }
  private ListNode merge(ListNode[] lists, int l, int r) {
    if(l == r) {
      return lists[l];
    }
    if (l > r) {
      return null;
    }
    int mid = l + (r - l) /2;
    return mergeTwoLists(merge(lists, l, mid), merge(lists, mid+1, r));
  }



  private ListNode mergeTwoLists(ListNode a, ListNode b) {
    if(a == null || b == null) {
      return a == null ? b : a;
    }
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (a != null && b != null) {
      if(a.val < b .val) {
        cur.next = a;
        a = a.next;
      } else {
        cur.next = b;
        b = b.next;
      }
      cur = cur.next;
    }
    cur.next = a == null? b: a;
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
