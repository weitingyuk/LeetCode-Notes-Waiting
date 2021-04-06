package Leetcode;

public class IsBalanced55 {
  /**Method:Recursion; Time:O(NLogN); Space:O(N) **/
  public boolean isBalanced(TreeNode root) { // isBalanced(): 判断树 root 是否平衡
    if(root == null || (root.left == null && root.right == null)) {
      return true;
    }
    return Math.abs(getLength(root.left) - getLength(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
  }

  private int getLength(TreeNode node) { // depth()： 计算树 root 的深度
    if(node == null) {
      return 0;
    }
    return Math.max(getLength(node.left), getLength(node.right)) +1;
  }

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
