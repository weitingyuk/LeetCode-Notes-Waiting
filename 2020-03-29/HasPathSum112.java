package Leetcode;

public class HasPathSum112 {
  /*Method : Recursive, Time: O(N), Space:O(H)**/
  public boolean hasPathSum(TreeNode root, int targetSum) {
    if(root == null) { // root 为空的时候，表示没有path, 所以返回false
      return false;
    }
    if(root.left == null && root.right == null) { //左右节点都为空，才行
      return root.val == targetSum;
    }
    return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum - root.val);
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
