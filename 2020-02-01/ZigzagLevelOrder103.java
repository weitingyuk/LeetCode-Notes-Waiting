package Leetcode;
import java.util.*;
public class ZigzagLevelOrder103 {

  /**Method1: Zigzag level order by queue; Time:O(n); Space:O(n) **/
  public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if(root == null) {
      return res;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean isOrderLeft = true;
    while(!queue.isEmpty()) {
      Deque<Integer> list= new LinkedList<>();
      int size = queue.size();
      for(int i=0; i<size; i++) {
        TreeNode node = queue.poll();
        if(isOrderLeft) {
          list.offerLast(node.val);
        }else{
          list.offerFirst(node.val);
        }
        if(node.left != null) {
          queue.offer(node.left);
        }
        if(node.right != null) {
          queue.offer(node.right);
        }
      }

      isOrderLeft=!isOrderLeft;
      res.add(new LinkedList<Integer>(list));
    }
    return res;
  }

  /**Method 2: DFS; Time:O(N); Space:O(H) **/
  List<List<Integer>> res = new ArrayList();
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if(root == null) {
      return res;
    }
    dfs(root, 0);
    return res;
  }
  public void dfs(TreeNode root, int level) {
    if (root == null)
      return;
    if(res.size() == level) {
      List<Integer> newLevel = new LinkedList<>();
      res.add(newLevel);
    }
    List<Integer> list = res.get(level);
    if(level % 2 == 0){
      list.add(root.val);
    } else {
      list.add(0, root.val);
    }
    dfs(root.left, level + 1);
    dfs(root.right, level + 1);
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
