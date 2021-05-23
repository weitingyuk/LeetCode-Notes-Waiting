package Leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BuildTree105 {
  /**
   Method: Iteration
   TIME: O(N)
   SPACE:O(N)
   */
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if(preorder == null || preorder.length == 0) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[0]);
    Deque<TreeNode> stack = new LinkedList<>();
    stack.push(root);
    int inorderIndex = 0;
    for(int i=1; i<preorder.length; i++) {
      int preVal = preorder[i];
      TreeNode node = stack.peek();
      if(node.val != inorder[inorderIndex]) {
        node.left = new TreeNode(preVal);
        stack.push(node.left);
      } else{
        while(!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
          node = stack.pop();
          inorderIndex ++;
        }
        node.right = new TreeNode(preVal);
        stack.push(node.right);
      }
    }
    return root;
  }
  /**
  Method: Recursion
  TIME: O(N)
  SPACE:O(N)
   */
  Map<Integer, Integer> map = new HashMap<>();
  private TreeNode buildTree(int[] preorder, int lPre, int rPre, int[] inorder, int lIn, int rIn){
    if(lPre > rPre) {
      return null;
    }
    TreeNode node = new TreeNode(preorder[lPre]);
    int inNum = map.get(preorder[lPre]);
    int leftSize = inNum - lIn;
    node.left = buildTree(preorder, lPre+1, lPre + leftSize, inorder, lIn, inNum-1);
    node.right = buildTree(preorder, lPre+leftSize+1, rPre, inorder, inNum+1, rIn);
    return node;
  }
  public TreeNode buildTree1(int[] preorder, int[] inorder) {
    int len = preorder.length;
    for(int i=0; i<len; i++) {
      map.put(inorder[i], i);
    }
    return buildTree(preorder, 0, len-1, inorder, 0, len-1);
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
