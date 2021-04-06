package Leetcode;

public class ClimbStairs70 {
  /* Method : DP; Time: O(N), Space:O(1)**/
  public int climbStairs(int n) {
    int pre = 0;
    int cur = 0;
    int sum = 1;
    for(int i=1; i<=n; i++) {
      pre = cur;
      cur = sum;
      sum = pre+cur;
    }
    return sum;
  }
}
