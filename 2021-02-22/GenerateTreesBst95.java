package Leetcode;


import java.util.LinkedList;
import java.util.List;

public class GenerateTreesBst95 {
  /**Method: Recursive; Time:O(nG(n)); Space: O(nG(n)), G(n) is Catalan number  **/
  public List<TreeNode> generateTrees(int n) {
    if(n == 0) {
      return new LinkedList<>();
    }
    return createTrees(1, n);
  }
  private List<TreeNode> createTrees(int start, int end) {
    List<TreeNode> trees = new LinkedList<>();
    if(start > end) {
      trees.add(null);
      return trees;
    }
    for(int i = start; i<= end; i++) {
      List<TreeNode> leftTrees = createTrees(start, i-1);
      List<TreeNode> rightTrees =  createTrees(i+1, end);
      for(TreeNode left: leftTrees) {
        for(TreeNode right: rightTrees) {
          TreeNode node = new TreeNode(i);
          node.left = left;
          node.right = right;
          trees.add(node);
        }
      }
    }
    return trees;
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
