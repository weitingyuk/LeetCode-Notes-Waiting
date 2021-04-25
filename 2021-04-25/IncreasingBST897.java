package Leetcode;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class IncreasingBST897 {
  /**Method: InOrder; Time: O(N); Space: O(N) **/
  /**
   对其进行「中序遍历」即可得到有序列表，再根据有序列表构建答案即可。
   **/
  List<TreeNode> res = new ArrayList<>();
  public TreeNode increasingBST(TreeNode root) {

    bfs(root);

    return getNode();
  }


  private TreeNode getNode() {
    TreeNode dummy = new TreeNode();
    TreeNode cur = dummy;
    for(TreeNode node:res ){
      cur.right = node;
      node.left = null; //注意：left == null;
      cur = node;
    }
    return dummy.right;
  }
  // Method 1: BFS
  private void bfs(TreeNode node) {
    Deque<TreeNode> q = new LinkedList<>();
    while(node != null || !q.isEmpty()) {
      while(node != null) {
        q.add(node);
        node = node.left;
      }
      node = q.pollLast();
      res.add(node);
      node = node.right;
    }
  }
  // Method 2: DFS
  private void dfs(TreeNode node) {
    if(node == null) {
      return;
    }
    dfs(node.left);
    res.add(node);
    dfs(node.right);
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
