package Leetcode;


public class InvertTree226 {
  /*Method : Recursive, Time: O(N), Space:O(N)**/
  public TreeNode invertTree(TreeNode root) {
    if(root == null) {
      return null;
    }

    TreeNode temp = invertTree(root.left);
    root.left = invertTree(root.right);
    root.right = temp;
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
