package Leetcode;


import java.util.Deque;
import java.util.LinkedList;

public class IsValidBST98 {

  /**Method 1: Recursive; Time:O(N); Space: O(N) **/
  public boolean isValidBST1(TreeNode root) {
    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }
  public boolean isValidBST(TreeNode node, long lower, long upper) {
    if(node == null) {
      return true;
    }
    if(node.val <= lower || node.val >= upper) {
      return false;
    }
    return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
  }

  /**Method 2: Iteration; Time:O(N); Space: O(N) **/
  public boolean isValidBST2(TreeNode root) {
    Deque<TreeNode> stack = new LinkedList<>();
    double lastVal = -Double.MAX_VALUE;
    TreeNode cur = root;
    while(!stack.isEmpty() || cur!=null) {
      while(cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      if(cur.val <= lastVal ) {
        return false;
      }
      lastVal = cur.val;
      cur = cur.right;
    }
    return true;
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
