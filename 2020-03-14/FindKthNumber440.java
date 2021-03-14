package Leetcode;

public class FindKthNumber440 {
  /** Method: Dictionary tree; Time:O(Len) & The Worst Time: O(K); Space:O(1) **/
  /** 思路: 字典数； 分两种情况：向右找 - cur++， 向下找 - cur *= 10。  **/
  public int findKthNumber(int n, int k) {
    int cur = 1;
    k = k-1;
    while(k>0) {
      int nums = getNums(n, cur, cur+1);
      if(nums <= k) {
        cur ++;
        k -= nums;
      } else {
        cur *= 10;
        k--;
      }
    }
    return cur;
  }
  private int getNums(int n, long first, long last) { //long 类型；
    int nums = 0;
    while(first <= n) {
      nums += Math.min(n+1, last) - first;
      first *= 10;
      last *= 10;
    }
    return nums;
  }

}
