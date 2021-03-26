package Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeBTree297 {
  /**Method: DFS; Time:O(N); Space: O(N) **/

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    return serialize(root, "");
  }
  private String serialize(TreeNode root, String str) {
    if(root == null) {
      str += "None,";
    } else {
      str += String.valueOf(root.val) + ",";
      str = serialize(root.left, str);
      str = serialize(root.right, str);
    }
    return str;
  }
  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    return deserialize(new LinkedList<>(Arrays.asList(data.split(",")))); //需要new list
  }
  private TreeNode deserialize(List<String> data) {
    if(data.get(0).equals("None")) {
      data.remove(0);
      return null; //移除并返回节点
    }
    TreeNode node=new TreeNode(Integer.valueOf(data.get(0)));
    data.remove(0);
    node.left = deserialize(data);
    node.right = deserialize(data);
    return node;
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
