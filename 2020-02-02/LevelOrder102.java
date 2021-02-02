package Leetcode;
import Leetcode.BuildTree105.TreeNode;
import java.util.*;

public class LevelOrder102 {

  /**Method 1: DFS; Time:O(N); Space:O(H) **/
  List<List<Integer>> res = new ArrayList<>();
  public List<List<Integer>> levelOrder01(TreeNode root) {
    if(root == null) {
      return res;
    }
    dfs(root, 0);
    return res;
  }

  private void dfs(TreeNode node, int level) {
    if (res.size() == level) {
      res.add(new ArrayList<>());
    }
    res.get(level).add(node.val);
    if(node.left != null) {
      dfs(node.left, level+1);
    }
    if(node.right != null) {
      dfs(node.right, level+1);
    }
  }

  /**Method 2: BFS - level order by queue; Time:O(N); Space:O(N) **/
  public List<List<Integer>> levelOrder02(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if(root == null) {
      return res;
    }
    Deque<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()) {
      List<Integer> list = new ArrayList<>();
      int size = queue.size();
      for(int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        list.add(node.val);
        if(node.left != null) {
          queue.add(node.left);
        }
        if(node.right != null) {
          queue.add(node.right);
        }
      }
      res.add(new ArrayList<>(list));

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
