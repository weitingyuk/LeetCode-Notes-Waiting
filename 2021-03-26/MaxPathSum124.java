package Leetcode;

public class MaxPathSum124 {
  /**Method: Recursion; Time:O(N); Space: O(N) **/
  int maxSum = Integer.MIN_VALUE;
  public int maxPathSum(TreeNode root) {
    maxGain(root);
    return maxSum;
  }


  private int maxGain(TreeNode node) {
    if(node == null) {
      return 0;
    }
    int leftGain = Math.max(maxGain(node.left), 0); //maxGain可能有node的和<0，所以要和0取最大值
    int rightGain = Math.max(maxGain(node.right), 0);
    int pathValue = node.val +leftGain + rightGain;
    maxSum = Math.max(pathValue, maxSum);
    return node.val + Math.max(leftGain, rightGain);
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
