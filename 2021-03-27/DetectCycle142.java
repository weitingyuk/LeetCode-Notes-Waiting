package Leetcode;

public class DetectCycle142 {
  /*Method : Two pointers, Time: O(N), Space:O(1)**/
  public ListNode detectCycle(ListNode head) {
    if(head == null || head.next == null) {
      return null; //为空
    }

    ListNode s = head;
    ListNode f = s.next; // f从s的下一个开始
    while( f!=s) {
      if(f ==null || f.next == null) { //f或者f.next为空，直接返回
        return null;
      }
      f = f.next.next;
      s = s.next;
    }
    s = head;
    f = f.next; // f从f的下一个开始
    while(s!=f) {
      s = s.next;
      f = f.next;
    }
    return s;
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
