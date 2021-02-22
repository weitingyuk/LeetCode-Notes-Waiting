package Leetcode;

import Leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SearchRangeLintcode11 {

  /**
   * @param root: param root: The root of the binary search tree
   * @param k1: An integer
   * @param k2: An integer
   * @return: return: Return all keys that k1<=key<=k2 in ascending order
   */
  public List<Integer> searchRange(TreeNode root, int k1, int k2) {
    // write your code here
    List<Integer> res =  new ArrayList<>();
    if(root == null) {
      return res;
    }
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur =  root;
    while(cur != null || !stack.isEmpty()) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      if(!stack.isEmpty()) {
        cur = stack.pop();
        if(cur.val >= k1 && cur.val <= k2) {
          res.add(cur.val);
        }
      }
      cur = cur.right;
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
