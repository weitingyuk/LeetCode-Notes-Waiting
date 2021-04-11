package Leetcode;

public class TreeToDoublyList36 {
  /*Method: DFS, Time: O(N), Space:O(N)**/
  /**
   思路：构建链表：
   当 pre 为空时： 代表正在访问链表头节点，记为 head ；
   当 pre 不为空时： 修改双向节点引用，即 pre.right = cur ，cur.left = pre ；
   保存 cur ： 更新 pre = cur ，即节点 cur 是后继节点的 pre ；
   递归右子树，即 dfs(cur.right) ；
   **/
  Node pre, head;
  public Node treeToDoublyList(Node root) {
    if(root == null) {
      return null;
    }
    dfs(root);
    head.left = pre;
    pre.right = head;
    return head;
  }
  void dfs(Node cur) {
    if(cur == null) {
      return;
    }
    dfs(cur.left);
    if(pre != null) {
      pre.right = cur;
    } else {
      head = cur;
    }
    cur.left = pre;
    pre = cur;
    dfs(cur.right);
  }

  // Definition for a Node.
  class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
      val = _val;
      left = _left;
      right = _right;
    }
  };
}
