package Leetcode;

import java.util.*;
public class LowestCommonAncestor236 {

  /**
   * Method: recursion
   * TIME: O(N)
   * SPACE:O(1)
   */
  /**
   * 终止条件：root == null || root == p || root == q
   * 如果有一个子节点是root，那root是公共祖先，肯定不会是子节点
   * **/
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null || root == p || root == q) {
      return root;
    }
    TreeNode lson = lowestCommonAncestor(root.left, p, q);
    TreeNode rson = lowestCommonAncestor(root.right, p, q);
    if(lson != null && rson != null) {
      return root;
    }
    return lson == null ? rson : lson;
  }

  /**
   METHOD: dsf, store parents and visited
   TIME: O(N)
   SPACE:O(N)
   **/
  Map<Integer, TreeNode> parents = new HashMap<>();
  List<Integer> visited = new ArrayList<>();
  private void dfs(TreeNode root){
    if(root.left != null) {
      parents.put(root.left.val, root);
      dfs(root.left);
    }
    if(root.right != null) {
      parents.put(root.right.val, root);
      dfs(root.right);
    }
  }
  public TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {
    dfs(root);
    while(p!= null) {
      visited.add(p.val);
      p = parents.get(p.val);
    }
    while(q != null) {
      if(visited.contains(q.val)) {
        return q;
      }
      q=parents.get(q.val);
    }
    return null;
  }
  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */