package Leetcode;

public class MinDiffInBST783 {
  /**Method: Iteration by InOrder; Time: O(N), Space: O(N) **/
  /**
   思路：二叉查找树中序遍历有序
   计算中序遍历中临近两节点之差的绝对值，取最小值
   **/
  int minDiff = Integer.MAX_VALUE;
  TreeNode pre = null; // 用全局变量记录前一个节点
  public int minDiffInBST(TreeNode root) {
    inOrder(root);
    return minDiff;
  }
  private void inOrder(TreeNode node) {
    if(node == null) {
      return;
    }
    inOrder(node.left);
    if(pre != null) {
      minDiff = Math.min(Math.abs(node.val-pre.val), minDiff);
    }
    pre = node;
    inOrder(node.right);
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
