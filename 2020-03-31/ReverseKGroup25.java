package Leetcode;

public class ReverseKGroup25 {
  /*Method: Pointers, Time: O(n∗K), Space:O(1)**/
  public ListNode reverseKGroup(ListNode head, int k) {
    if(head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    //初始需要两个变量 pre 和 end，pre 代表待翻转链表的前驱，end 代表待翻转链表的末尾
    ListNode pre = dummy;
    ListNode end = dummy;
    while(end.next != null) {
      for(int i=0; i< k && end != null; i++) {
        end = end.next;
      }
      if(end == null) {
        break;
      }
      ListNode start = pre.next;
      ListNode np = end.next; //经过k此循环，end 到达末尾，记录待翻转链表的后继 np = end.next
      end.next = null;
      pre.next = reverse(start);

      start.next = np;
      pre = start;
      end = pre;

    }
    return dummy.next;
  }

  private ListNode reverse(ListNode head) {
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


  //Definition for singly-linked list.
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
