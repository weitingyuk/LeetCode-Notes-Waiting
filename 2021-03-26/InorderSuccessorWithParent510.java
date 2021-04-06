package Leetcode;

public class InorderSuccessorWithParent510 {

  /**Method: Iteration; Time:O(H); Space: O(1) **/
  public Node inorderSuccessor(Node node) {
    if(node == null) {
      return null;
    }
    if(node.right != null) {
      node = node.right;
      while(node.left != null) {
        node = node.left;
      }
      return node;
    }
    while(node.parent != null && node.parent.right == node) {
      node = node.parent;
    }
    return node.parent; // 返回的节点的父节点
  }

  class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
  };

}
