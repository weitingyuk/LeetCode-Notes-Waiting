package Leetcode;
import java.util.*;

public class InorderTraversal94 {


  /**Method 1: Iteration; Time:O(N); Space:O(N) **/
  public List<Integer> inorderTraversal1(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    inOrder(root, res);
    return res;
  }
  private void inOrder(TreeNode node, List<Integer> res) {
    if(node == null) {
      return;
    }
    inOrder(node.left, res);
    res.add(node.val);
    inOrder(node.right, res);
  }

  /**Method 2: Not Iteration; Time:O(N); Space:O(N) **/
  public List<Integer> inorderTraversal2(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Deque<TreeNode> queue = new LinkedList<>();
    while(root!=null || !queue.isEmpty()) {
      while(root!=null) {
        queue.push(root);
        root = root.left;
      }
      root = queue.pop();
      res.add(root.val);
      root = root.right;
    }
    return res;
  }

  /**Method 3: Morris; Time:O(N); Space:O(1) **/
  public List<Integer> inorderTraversal3(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    TreeNode node = null;
    while(root!= null) {
      if(root.left != null) {
        node = root.left;
        while(node.right != null && node.right != root) {
          node  = node.right;
        }
        if(node.right == null) {
          node.right = root;
          root = root.left;
        } else {
          res.add(root.val);
          node.right = null;
          root = root.right;
        }
      } else {
        res.add(root.val);
        root = root.right;
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
