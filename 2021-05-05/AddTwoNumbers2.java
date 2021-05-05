package Leetcode;

public class AddTwoNumbers2 {

  /**Method: Mock Add; Time:O(Max(M,N)); Space: O(1) **/
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry =0;
    ListNode dummy = new ListNode();
    ListNode cur = dummy;
    while(l1 != null || l2 != null || carry !=0 ){
      int x = l1 == null ? 0: l1.val;
      int y = l2 == null ? 0: l2.val;
      int sum=x+y+carry;
      ListNode node = new ListNode(sum %10);
      carry = sum /10;
      cur.next = node;
      cur = node;
      if(l1!=null) { //记住 l1, l2需要next
        l1=l1.next;
      }
      if(l2!=null) {
        l2=l2.next;
      }
    }
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
