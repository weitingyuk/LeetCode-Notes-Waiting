package Leetcode;

import Leetcode.IsSymmetric803.TreeNode;

public class LowestCommonAncestor235 {


  /**Method: recursion; Time: O(N), Space: O(H) **/
  /**
   我们从根节点开始遍历；
   如果当前节点的值大于 pp 和 qq 的值，说明 pp 和 qq 应该在当前节点的左子树，因此将当前节点移动到它的左子节点；
   如果当前节点的值小于 pp 和 qq 的值，说明 pp 和 qq 应该在当前节点的右子树，因此将当前节点移动到它的右子节点；
   如果当前节点的值不满足上述两条要求，那么说明当前节点就是「分岔点」。此时，pp 和 qq 要么在当前节点的不同的子树中，要么其中一个就是当前节点。
   **/
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
    if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
    return root;
  }

  /**Method: Loop; Time: O(N), Space: O(1) **/
  /**
   我们从根节点开始遍历；
   如果当前节点的值大于 pp 和 qq 的值，说明 pp 和 qq 应该在当前节点的左子树，因此将当前节点移动到它的左子节点；
   如果当前节点的值小于 pp 和 qq 的值，说明 pp 和 qq 应该在当前节点的右子树，因此将当前节点移动到它的右子节点；
   如果当前节点的值不满足上述两条要求，那么说明当前节点就是「分岔点」。此时，pp 和 qq 要么在当前节点的不同的子树中，要么其中一个就是当前节点。
   **/
  public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode parent = root;
    while (true) {
      if (p.val < parent.val && q.val < parent.val) {
        parent = parent.left;
      } else if (p.val > parent.val && q.val > parent.val) {
        parent = parent.right;
      } else {
        break;
      }
    }
    return parent;
  }
}
