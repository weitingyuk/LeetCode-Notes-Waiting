package Leetcode;

public class InsertNodeBstLintcode85 {
  /*
   * @param root: The root of the binary search tree.
   * @param node: insert this node into the binary search tree
   * @return: The root of the new binary search tree.
   */
  /**Method: Recursive; Time:O(H); Space: O(H) **/
  public TreeNode insertNode(TreeNode root, TreeNode node) {
    // write your code here
    if(root == null) {
      return node;
    }
    if(node.val < root.val) {
      root.left = insertNode(root.left, node);
    } else if (node.val > root.val) {
      root.right = insertNode(root.right, node);
    }
    return root;
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
