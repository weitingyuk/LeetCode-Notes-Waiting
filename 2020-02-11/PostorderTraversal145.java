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

  /**Method 3: Morris; Time:O(N); Space:O(1) **/
  public List<Integer> postorderTraversal3(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if(root == null) {   return res;   }
    TreeNode cur = root, mostRight = null;
    while(cur != null) {
      mostRight = cur.left;
      if(mostRight != null) {
        while(mostRight.right != null && mostRight.right != cur) {
          mostRight = mostRight.right;
        }
        if(mostRight.right == null) {
          mostRight.right = cur;
          cur = cur.left;
          continue;
        } else {
          mostRight.right = null;
          addPath(res, cur.left);
        }
      }
      cur = cur.right;
    }
    addPath(res, root);
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
