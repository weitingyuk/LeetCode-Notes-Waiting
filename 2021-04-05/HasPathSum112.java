package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

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


  /**Method2: BFS; Time: O(N), Space: O(H) **/
  /**思路：
   两个栈，一个保存将要遍历的节点，一个保存根节点到这些节点的路径和。
   **/
  public boolean hasPathSum2(TreeNode root, int targetSum) {
    if(root == null) {
      return false;
    }
    Queue<TreeNode> qNode = new LinkedList<>();
    Queue<Integer> qSum = new LinkedList<>();
    qNode.offer(root);
    qSum.offer(root.val);
    while(!qNode.isEmpty()) {
      TreeNode node = qNode.poll();
      int temp = qSum.poll();
      if(node.left == null && node.right == null) {
        if(temp == targetSum) {
          return true;
        }
        continue;
      }
      if(node.left != null) {
        qNode.offer(node.left);
        qSum.offer(temp + node.left.val);
      }
      if(node.right != null) {
        qNode.offer(node.right);
        qSum.offer(temp + node.right.val);
      }
    }
    return false;
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
