package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BSTIterator173 {
  /**Method1: ArrayList store by inOrder; Time: Constructor-O(N), next()-O(1), hasNext()-O(1); Space: O(N) **/
  List<Integer> nodeSorted;
  int index;
  public BSTIterator173(TreeNode root) {
    this.nodeSorted = new ArrayList<>();
    index = -1;
    inOrder(root);
  }
  private void inOrder(TreeNode root) {
    if(root == null) {
      return;
    }
    inOrder(root.left);
    nodeSorted.add(root.val);
    inOrder(root.right);
  }
  public int next() {
    return nodeSorted.get(++index);
  }

  public boolean hasNext() {
    return index+1 < nodeSorted.size();
  }
  /**Method2: Store data in an stack; Time: Constructor-O(H), next()-O(H), hasNext()-O(1); Space: O(H) **/
  class BSTIterator {
    Stack<TreeNode> stack;

    BSTIterator(TreeNode root) {
      this.stack = new Stack<>();
      pushMostLeft(root);
    }
    private void pushMostLeft(TreeNode root) {
      while(root != null) {
        stack.push(root);
        root = root.left;
      }
    }
    public int next2() {
      TreeNode topNode = stack.pop();
      if(topNode.right != null) {
        pushMostLeft(topNode.right);
      }
      return topNode.val;
    }

    public boolean hasNext2() {
      return stack.size() > 0;
    }
  }


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


