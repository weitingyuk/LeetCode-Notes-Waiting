package Leetcode;

import Leetcode.IsSymmetric803.TreeNode;

public class IsSameTree100 {
  /**Method: Recursive; Time:O(Min(M,N)); Space: O(Min(M,N)) **/
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if(p==null && q==null) {
      return true;
    }
    if(p == null || q == null) {
      return false;
    }
    if(p.val != q.val) {
      return false;
    }
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

  }

}
