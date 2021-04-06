package Leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreorderTraversal144 {
  /**Method 1: Iteration; Time:O(N); Space:O(N) **/
  public List<Integer> preorderTraversal1(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    preorder(root, res);
    return res;
  }
  private void preorder(TreeNode node, List<Integer> list) {
    if(node == null) {
      return;
    }
    list.add(node.val);
    preorder(node.left, list);
    preorder(node.right, list);
  }

  /**Method 2: Not Iteration - Queue; Time:O(N); Space:O(N) **/
  public List<Integer> preorderTraversal2(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if(root == null) {
      return res;
    }

    Deque<TreeNode> queue = new LinkedList<>();
    while(!queue.isEmpty() || root != null) {
      while(root!=null) {
        res.add(root.val);
        queue.push(root);
        root = root.left;
      }
      root = queue.pop();
      root = root.right;
    }
    return res;
  }

  /**Method 3: Morris; Time:O(N); Space:O(1) **/
  public List<Integer> preorderTraversal3(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if(root == null) {
      return res;
    }
    TreeNode cur = root, mostRight = null;
    while(cur != null) {
      mostRight = cur.left;
      if(mostRight != null) {
        while(mostRight.right != null && mostRight.right != cur) {
          mostRight = mostRight.right;
        }
        if(mostRight.right == null) {
          res.add(cur.val);
          mostRight.right = cur;
          cur = cur.left;
          continue;
        } else {
          mostRight = null;
        }
      } else {
        res.add(cur.val);
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
