package Leetcode;

import Leetcode.IsSymmetric803.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView199 {
  /**Method1: DFS：; Time:O(N)); Space: O(H) **/
  /**
   DFS：  我们按照 「根结点 -> 右子树 -> 左子树」 的顺序访问，就可以保证每层都是最先访问最右边的节点的。
   **/
  List<Integer> res =new ArrayList<>();
  public List<Integer> rightSideView(TreeNode root) {
    dfs(root, 0);
    return res;
  }
  private void dfs(TreeNode node, int dept){
    if(node == null) {
      return;
    }
    if(dept == res.size()) { // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
      res.add(node.val);
    }
    dept++;
    dfs(node.right, dept);
    dfs(node.left, dept);
  }

  /**Method2: BFS; Time:O(N); Space: O(N) **/
  /**
   对二叉树进行层次遍历，那么对于每层来说，最右边的结点一定是最后被遍历到的
   **/
  public List<Integer> rightSideView2(TreeNode root) {
    List<Integer> res =new ArrayList<>();
    if(root ==null) {
      return res;
    }
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    while(!q.isEmpty()) {
      int size = q.size();
      for(int i=0; i<size; i++){
        TreeNode node = q.remove();
        if(node.left != null) {
          q.add(node.left);
        }
        if(node.right != null) {
          q.add(node.right);
        }
        if(i == size-1) {
          res.add(node.val);
        }
      }
    }
    return res;
  }
}
