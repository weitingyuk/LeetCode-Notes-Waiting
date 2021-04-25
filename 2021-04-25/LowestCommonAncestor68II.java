package Leetcode;
import Leetcode.IsSymmetric803.TreeNode;
public class LowestCommonAncestor68II {
  /* Method: DFS, Time: O(N), Space:O(H)**/
  /**
   我们从根节点开始遍历；
   如果当前节点的值大于 p 和 q 的值，说明 p 和 q 应该在当前节点的左子树，因此将当前节点移动到它的左子节点；
   如果当前节点的值小于 p 和 q 的值，说明 p 和 q 应该在当前节点的右子树，因此将当前节点移动到它的右子节点；
   p 和 q 要么在当前节点的不同的子树中，要么其中一个就是当前节点。`
   **/
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null || root == p || root == q) {
      return root;
    }
    TreeNode lson = lowestCommonAncestor(root.left, p, q);
    TreeNode rson = lowestCommonAncestor(root.right, p, q);
    if(lson == null){
      return rson;
    }
    if(rson == null) {
      return lson;
    }
    return root;

  }

}
