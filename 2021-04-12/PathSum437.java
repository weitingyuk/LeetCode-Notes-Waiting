package Leetcode;


public class PathSum437 {
  /*Method: Iteration, Time: O(NLogN), Space:O(1)**/
  /**路径不一定以root开头，也不一定以leaf结尾，但一定连续 **/
  public int pathSum(TreeNode root, int sum) {
    if(root == null) {
      return 0;
    }
    return pathSumStartWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum); // 左右子树是pathSum方法，因为可以从左右子树开始，或者是左右子树的子树开始
  }
  private int pathSumStartWithRoot(TreeNode root, int sum) {
    if(root == null) {
      return 0;
    }
    int res = 0;
    if(root.val == sum){
      res = 1;
    }
    res += pathSumStartWithRoot(root.left, sum-root.val) + pathSumStartWithRoot(root.right, sum-root.val);
    return res;
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
