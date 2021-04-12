package Leetcode;


public class SortedArrayToBST108 {
  /*Method: In order, Time: O(N), Space:O(N)**/
  /**
   中序遍历，总是选择中间位置左边的数字作为根节点
   选择中间位置左边的数字作为根节点，则根节点的下标为 mid = (left + right) / 2，此处的除法为整数除法。
   **/
  public TreeNode sortedArrayToBST(int[] nums) {
    return toBST(nums, 0, nums.length - 1);
  }
  private TreeNode toBST(int[] nums, int left, int right) {
    if (left > right) {
      return null;
    }
    // 总是选择中间位置左边的数字作为根节点
    int mid = (left + right) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = toBST(nums, left, mid - 1);
    root.right = toBST(nums, mid + 1, right);
    return root;
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
