package Leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BuildTree105 {
  /**
   Method: recursion
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
  Method: iteration
  TIME: O(N)
  SPACE:O(N)
   */
  Map<Integer, Integer> indexMap;
  public TreeNode buildMyTree(int[] preorder, int[] inorder, int leftPre, int rightPre, int leftIn, int rightIn) {
    if(leftPre>rightPre) {
      return null;
    }
    int rootPre = leftPre;
    int rootIn = indexMap.get(preorder[rootPre]);
    TreeNode root = new TreeNode(preorder[rootPre]);
    int size_left = rootIn - leftIn;
    root.left = buildMyTree(preorder, inorder, leftPre+1, leftPre + size_left, leftIn, rootIn-1);
    root.right = buildMyTree(preorder, inorder, leftPre + size_left+1, rightPre, rootIn+1, rightIn);
    return root;
  }
  public TreeNode buildTree1(int[] preorder, int[] inorder) {
    indexMap = new HashMap<>();
    int n = preorder.length;
    for(int i=0;i<n;i++) {
      indexMap.put(inorder[i], i);
    }
    return buildMyTree(preorder, inorder, 0, n-1, 0, n-1);
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
