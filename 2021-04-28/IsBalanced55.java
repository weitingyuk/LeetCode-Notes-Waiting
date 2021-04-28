package Leetcode;

public class IsBalanced55 {
  /*Method: Recursion, Time: O(N^2), Space:O(N)**/
  /**
   计算节点高度的函数，即可判断二叉树是否平衡。
   具体做法类似于二叉树的前序遍历，即对于当前遍历到的节点，
   首先计算左右子树的高度，如果左右子树的高度差是否不超过 1，再分别递归地遍历左右子节点，并判断左子树和右子树是否平衡。
   **/
  public boolean isBalanced(TreeNode root) {
    if(root == null) {
      return true;
    }
    return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
  }

  private int getHeight(TreeNode node) {
    if(node == null) {
      return 0;
    }
    return Math.max(getHeight(node.left), getHeight(node.right)) +1;
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
