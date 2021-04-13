package Leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerateTreesBst95 {
  /**Method: Recursive; Time:O(nG(n)); Space: O(nG(n)), G(n) is Catalan number  **/
  public List<TreeNode> generateTrees(int n) {
    if(n==0) {
      return new ArrayList<TreeNode>();
    }
    return generateTrees(1, n);
  }
  private List<TreeNode> generateTrees(int s, int e) {
    List<TreeNode> tree = new ArrayList<>();
    if(s>e) {
      tree.add(null);//这里为空，加入node 链表
      return tree;
    }
    for(int i=s;i<=e;i++) {
      List<TreeNode> left = generateTrees(s, i-1); // 分为左右子树的数组
      List<TreeNode> right = generateTrees(i+1, e);
      for(TreeNode l: left) {
        for(TreeNode r: right) {
          TreeNode node = new TreeNode(i);
          node.left = l;
          node.right = r;
          tree.add(node);
        }
      }
    }
    return tree;
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
