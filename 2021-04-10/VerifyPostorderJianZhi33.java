package Leetcode;

public class VerifyPostorderJianZhi33 {
  /*Method1: recur, Time: O(N), Space:O(H)**/
  /**
   思路：遍历后序遍历的 [i, j]区间元素，寻找 第一个大于根节点 的节点，索引记为 m 。此时，可划分出左子树区间 [i,m-1]、右子树区间 [m, j - 1] 、根节点索引 j 。
   1. p = j ： 判断 此树 是否正确。
   2. recur(i, m - 1) ： 判断 此树的左子树 是否正确。
   3. recur(m, j - 1) ： 判断 此树的右子树 是否正确。
   **/
  public boolean verifyPostorder(int[] postorder) {
    return recur(postorder, 0, postorder.length - 1);
  }

  private boolean recur(int[] postOrder, int s, int e) {
    if(s>=e) {
      return true;
    }
    int p = s;
    while(postOrder[p] < postOrder[e]) {
      p++;
    }
    int m = p;
    while(postOrder[p] > postOrder[e]) {
      p++;
    }
    return p==e && recur(postOrder, s, m-1) && recur(postOrder, m, e-1);
  }

}
