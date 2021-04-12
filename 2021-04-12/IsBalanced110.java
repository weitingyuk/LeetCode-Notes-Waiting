package Leetcode;


public class IsBalanced110 {
  /*Method : Recursive, Time: O(N^2), Space:O(N)**/
  boolean result = true; //全局返回值
  public boolean isBalanced(TreeNode root) {
    if(root == null) {
      return true; //为null是balance的
    }
    getDepth(root);
    return result;
  }

  private int getDepth(TreeNode node) {
    if(node == null) {
      return 0;
    }
    int leftH = getDepth(node.left);
    int rightH = getDepth(node.right);
    if(Math.abs(leftH - rightH) > 1){
      result = false;
    }
    return 1+ Math.max(leftH, rightH);
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
