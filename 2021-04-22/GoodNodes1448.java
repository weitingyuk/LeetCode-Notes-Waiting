package Leetcode;

import Leetcode.BinTree.MaxPathSum124;


public class GoodNodes1448 {

  /**Method: Recursion; Time:O(N); Space: O(H) **/
  /**
   引入辅助函数 countGoodNodes，逻辑为：
   1.该函数保留当前节点前的路径上的最大值 maxValue
   2.如果当前节点的值更大，计数并更新 maxValue，再继续向左、右节点递归
   3.空节点递归终止
   **/
  int cnt = 0;
  public int goodNodes(TreeNode root) {
    countGoodNodes(root, Integer.MIN_VALUE);
    return cnt;
  }
  private void countGoodNodes(TreeNode root, int maxValue) {
    if (root == null) return;
    if (root.val >= maxValue) {
      cnt++;
      maxValue = root.val;
    }
    countGoodNodes(root.left, maxValue);
    countGoodNodes(root.right, maxValue);
  }

  /**
   * Definition for a binary tree node.
   */
  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

}
