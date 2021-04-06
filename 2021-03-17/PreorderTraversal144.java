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
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if(root == null) {
      return res;
    }
    Deque<TreeNode> q = new LinkedList<>();
    while(!q.isEmpty() || root!=null) {
      while(root!=null) {
        q.push(root);
        res.add(root.val);
        root = root.left;
      }
      root = q.pop();
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

  public void addPath(List<Integer> res, TreeNode node) {
    int count = 0;
    while (node != null) {
      ++count;
      res.add(node.val);
      node = node.right;
    }
    int left = res.size() - count, right = res.size() - 1;
    while (left < right) {
      int temp = res.get(left);
      res.set(left, res.get(right));
      res.set(right, temp);
      left++;
      right--;
    }
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
