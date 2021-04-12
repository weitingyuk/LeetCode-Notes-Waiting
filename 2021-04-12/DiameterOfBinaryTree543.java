package Leetcode;

public class DiameterOfBinaryTree543 {
  /*Method: Iteration, Time: O(N), Space:O(H)**/
  /**
   直径 = 左子树高度 + 右子树高度；不包含当前节点，看示例是返回3 = 左边（2） +右边（1）
   **/
  int maxD = 0; //全局变量
  public int diameterOfBinaryTree(TreeNode root) {
    getMaxDepth(root);
    return maxD;
  }

  private int getMaxDepth(TreeNode node) {
    if(node == null) {
      return 0;
    }
    int leftH = getMaxDepth(node.left);
    int rightH = getMaxDepth(node.right);
    maxD = Math.max(maxD, leftH+rightH); //直径 = 左子树高度 + 右子树高度；
    return Math.max(leftH, rightH) +1;
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
