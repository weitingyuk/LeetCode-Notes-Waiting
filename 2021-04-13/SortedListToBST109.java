package Leetcode;


import Leetcode.RemoveNthFromEnd19.ListNode;

public class SortedListToBST109 {
  /*Method : Divide and conquer, Time: O(NLogN), Space:O(LogN)**/
  /**
   1. 用快慢指针找出中间节点的前一个节点，
   2. 再以中间节点为界，分开处理
   **/
  public TreeNode sortedListToBST(ListNode head) {
    if(head == null){
      return null;
    }
    if(head.next == null) {
      return new TreeNode(head.val);
    }
    ListNode preMid = getPreMid(head);
    TreeNode root = new TreeNode(head.val);
    root.left =  sortedListToBST(preMid);
    root.right = sortedListToBST(preMid.next);
    return root;
  }

  private ListNode getPreMid(ListNode node) {
    ListNode slow = node;
    ListNode fast = node.next;//找mid的pre
    while(fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  //Definition for a binary tree node.
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

}
