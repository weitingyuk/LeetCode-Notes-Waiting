package Leetcode;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class IsValidBST98 {

  /**Method 1: Recursive; Time:O(N); Space: O(N) **/
  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE); //注意是long型
  }

  private boolean isValidBST(TreeNode root, long lower, long high) {
    if(root == null) {
      return true;
    }
    if(root.val <= lower || root.val >= high) {
      return false;
    }
    return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, high);
  }

  /**Method 2: Iteration; Time:O(N); Space: O(N) **/
  public boolean isValidBST2(TreeNode root) {
    Stack<TreeNode> s = new Stack<>();
    long lastV = -Long.MAX_VALUE;
    while(!s.isEmpty() || root!=null) { //注意是long型
      while(root!=null) {
        s.push(root);
        root = root.left;
      }
      root = s.pop();
      if(root.val <= lastV){
        return false;
      }
      lastV = root.val;
      root = root.right;
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
