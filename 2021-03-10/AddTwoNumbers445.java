package Leetcode;


import java.util.Stack;

public class AddTwoNumbers445 {
  /**Method: Stack + Big Data Sum; Time:O(N); Space: O(1) **/
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Stack<Integer> stack1 = buildStack(l1);
    Stack<Integer> stack2 = buildStack(l2);
    int carry = 0;
    ListNode head = new ListNode(-1);
    while(!stack1.isEmpty() || ! stack2.isEmpty() || carry != 0 ) {
      int x = stack1.isEmpty() ? 0 : stack1.pop();
      int y = stack2.isEmpty() ? 0 : stack2.pop();
      int sum = x+y+carry;
      ListNode cur = new ListNode(sum % 10);
      cur.next = head.next;
      head.next = cur;
      carry = sum / 10;
    }
    return head.next;
  }

  private Stack<Integer> buildStack(ListNode node){
    Stack<Integer> stack = new Stack<>();
    while(node != null) {
      stack.push(node.val);
      node =node.next;
    }
    return stack;
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
