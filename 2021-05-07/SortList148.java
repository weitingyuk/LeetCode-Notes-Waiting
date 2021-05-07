package Leetcode;

public class SortList148 {

  /** Method: Merge; Time: O(NLogN);  Space:O(LogN);**/
  /**
   1. 找到链表的中点，以中点为分界，将链表拆分成两个子链表。寻找链表的中点可以使用快慢指针法。
   2. 对两个子链表分别排序。
   3. 将两个排序后的子链表合并，得到完整的排序后的链表。
   **/
  public ListNode sortList(ListNode head) {
    return sortList(head,null);
  }

  public ListNode sortList(ListNode head, ListNode tail) {
    if(head == null) {
      return head;
    }
    if(head.next == tail) {
      head.next = null;
      return head;
    }
    ListNode mid = getMid(head, tail);
    ListNode list1 = sortList(head, mid);
    ListNode list2 = sortList(mid, tail);
    ListNode sorted = merge(list1, list2);
    return sorted;
  }

  private ListNode getMid(ListNode head, ListNode tail) {
    ListNode slow = head, fast = head;
    while(fast != tail) {
      slow = slow.next;
      fast = fast.next;
      if(fast != tail) {
        fast = fast.next;
      }
    }
    return slow;
  }

  public ListNode merge(ListNode node1, ListNode node2) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy, l1 = node1, l2 = node2;
    while(l1 != null && l2 != null) {
      if(l1.val <= l2.val) {
        cur.next = l1;
        l1 = l1.next;
      } else {
        cur.next = l2;
        l2 = l2.next;
      }
      cur = cur.next;
    }
    cur.next = l1 == null? l2 : l1;
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
