package Leetcode;


public class PartitionList86 {
  /** Method:Iteration + two pointers, Time: O(N), Space:O(1)**/
  public ListNode partition(ListNode head, int x) {
    ListNode preS = new ListNode(0);
    ListNode preH = new ListNode(0);
    ListNode curS = preS;
    ListNode curH = preH;
    while(head != null) {
      if(head.val < x) {
        curS.next = head;
        curS = curS.next;
      } else {
        curH.next = head;
        curH = curH.next;
      }
      head = head.next;
    }
    curH.next = null; //高的链表的next要连接到低的
    curS.next = preH.next; //合并list
    return preS.next;
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
