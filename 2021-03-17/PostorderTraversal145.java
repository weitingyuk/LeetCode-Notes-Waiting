package Leetcode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PostorderTraversal145 {
  /**Method 1: Iteration; Time:O(N); Space:O(N) **/
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    dfs(root, res);
    return res;
  }

  private void dfs(TreeNode node, List<Integer> res) {
    if(node == null) {
      return;
    }
    dfs(node.left, res);
    dfs(node.right, res);
    res.add(node.val);
  }
  /**Method 2: Not Iteration - Queue; Time:O(N); Space:O(N) **/
  public List<Integer> postorderTraversal2(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if(root == null) {
      return res;
    }
    Deque<TreeNode> queue = new LinkedList<>();
    TreeNode prev = null;
    while(!queue.isEmpty() || root != null) {
      while(root != null) {
        queue.push(root);
        root = root.left;
      }
      root = queue.pop();
      if(root.right == null || root.right == prev) {
        res.add(root.val);
        prev = root;
        root = null;
      } else {
        queue.push(root);
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
