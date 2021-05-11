package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Preorder589 {
  /*Method: Iterator, Time: O(N), Space:O(H)**/
  public List<Integer> preorder(Node root) {
    List<Integer> res=new ArrayList<>();
    if(root == null) {
      return res;
    }
    Stack<Node> s = new Stack<>();
    s.push(root);
    while(!s.isEmpty()) {
      Node node = s.pop();
      res.add(node.val);
      Collections.reverse(node.children);
      for(Node child: node.children) {
        s.push(child);
      }

    }
    return res;
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
