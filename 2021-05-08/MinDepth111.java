package Leetcode;

import Leetcode.IsSymmetric803.TreeNode;

public class MinDepth111 {
  /** Method: DFS; Time: O(N);  Space:O(H);**/
  /**
   对于每一个非叶子节点，我们只需要分别计算其左右子树的最小叶子节点深度。
   **/
  public int minDepth(TreeNode root) {
    if(root == null) {
      return 0;
    }
    if(root.left == null && root.right == null){
      return 1;
    }
    int minLen = Integer.MAX_VALUE;
    if(root.left != null){
      minLen = Math.min(minDepth(root.left), minLen);
    }
    if(root.right != null) {
      minLen = Math.min(minDepth(root.right), minLen);
    }
    return minLen+1;
  }

}
