package Leetcode;

import java.util.List;

public class MaxDepth559 {
  /*Method: Recursion, Time: O(N), Space:O(H)**/
  public int maxDepth(Node root) {
    if(root == null) {
      return 0;
    }

    List<Node> chList = root.children;
    int maxChildLen = 0;
    for(Node child: chList) {
      maxChildLen = Math.max(maxDepth(child), maxChildLen);
    }
    return maxChildLen+1;
  }

  class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  };
}
