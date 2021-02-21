package Leetcode;

import java.util.List;
import java.util.Stack;

public class InorderSuccessor285 {
  /**Method 1: Not Iteration; Time:O(H); Space:O(1)-O(H) **/
  public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
    if(root == null) {
      return null;
    }
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;
    boolean flag = false;
    while(cur != null || !stack.isEmpty()) {
      while(cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      if(!stack.isEmpty()) {
        cur = stack.pop();
        if(flag) {
          return cur;
        }
        if(cur == p) {
          flag = true;
        }
      }
      cur = cur.right;
    }
    return null;
  }

  /**Method 2: Iteration; Time:O(H); Space: O(H) **/
  public static TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
    if(root == null || p == null) {
      return null;
    }
    if(root.val <= p.val) {
      return inorderSuccessor2(root.right, p);
    }
    TreeNode node = inorderSuccessor2(root.left, p);
    if(node != null && node.val < root.val) {
      return node;
    } else {
      return root;
    }
  }

  /**Method 3: Recursive; Time:O(H); Space: O(1) **/
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if(root == null || p == null) {
      return null;
    }
    TreeNode cur = root;
    TreeNode res = null;
    while(cur != null) {
      if(cur.val <= p.val) {
        cur = cur.right;
      } else {
        if(res == null || res.val > cur.val) {
          res = cur;
        }
        cur = cur.left;
      }
    }
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
