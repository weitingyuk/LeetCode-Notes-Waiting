package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BSTIterator173 {
  /**Method1: ArrayList store by inOrder; Time: Constructor-O(N), next()-O(1), hasNext()-O(1); Space: O(N) **/
  /**
   * 中序遍历:
   1. 直接递归中序遍历
   2. 把中序内容存到list中
   3. 逐个返回list的值
   **/
  List<Integer> list;
  int index;
  public BSTIterator173(TreeNode root) {
    this.list = new ArrayList<>();
    index = 0;
    inOrder(root);
  }

  private void inOrder(TreeNode root) {
    if(root == null) {
      return;
    }
    inOrder(root.left);
    this.list.add(root.val);
    inOrder(root.right);
  }

  public int next() {
    return this.list.get(index++);
  }

  public boolean hasNext() {
    return index < this.list.size();
  }



  /**Method2: Store data in an stack; Time: Constructor-O(H), next()-O(H), hasNext()-O(1); Space: O(H) **/
  class BSTIterator {
    /**
     * 中序遍历:
     1. 先把根节点的左子节点都入栈: 例如,先把7, 3分别入栈,
     2. stack中最上面的节点就是最左节点,就是next的输出节点,最上节点为3,
     3. 同时要考虑next如果有右子树,要作为next的下一个元素
     **/
    Stack<TreeNode> stack;
    TreeNode cur;
    public BSTIterator(TreeNode root) {
      stack = new Stack<TreeNode>();
      cur = root;
    }

    public int next() {
      while(cur!=null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      int res = cur.val;
      cur = cur.right;
      return res;
    }

    public boolean hasNext() {
      return !stack.isEmpty() || cur != null;
    }
  }


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


