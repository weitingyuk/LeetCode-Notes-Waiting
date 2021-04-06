package Leetcode;

public class MaxPathSum124 {
  /**Method: Recursion; Time:O(N); Space: O(N) **/
  int maxSum = Integer.MIN_VALUE;
  public int maxPathSum(TreeNode root) {
    maxGain(root);
    return maxSum;
  }
  private int maxGain(TreeNode root) {
    if(root == null) {
      return 0;
    }
    int leftGain = Math.max(maxGain(root.left) , 0);
    int rightGain = Math.max(maxGain(root.right), 0);
    int curGain = root.val + leftGain + rightGain;
    maxSum = Math.max(maxSum, curGain);
    return root.val + Math.max(leftGain, rightGain);
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
