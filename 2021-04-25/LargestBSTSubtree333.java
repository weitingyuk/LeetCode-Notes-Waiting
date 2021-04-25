package Leetcode;


public class LargestBSTSubtree333 {

  /**Method: InOrder; Time: O(N); Space: O(H) **/
  /**
   根据二叉搜索树的性质我们分左右两个子树递归下去，即对于左子树，检查 valid(root−>left,l,root−>val)
   因为左子树里所有节点的值均小于它的根节点的值，所以我们要把范围从 (l,r) 改为 (l,root−>val)
   同理对于右子树我们递归检查 valid(root->right,root->val,r)即可，
   **/
  public int largestBSTSubtree(TreeNode root) {
    if(root == null ){
      return 0;
    }
    if(valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
      return cnt(root);
    }
    return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
  }

  private int cnt(TreeNode root){
    return root != null? cnt(root.left) + cnt(root.right) + 1: 0;
  }

  private boolean valid(TreeNode root,int l, int r) {
    if(root == null) {
      return true;
    }
    if(root.val <= l || root.val >= r) {
      return false;
    }
    return valid(root.left, l, root.val) && valid(root.right, root.val, r);
  }

  /**
   * Definition for a binary tree node.
   */
  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
