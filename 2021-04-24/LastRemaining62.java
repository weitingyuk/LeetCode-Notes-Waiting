package Leetcode;

public class LastRemaining62 {
  /**Method: DP; Time:O(N); Space: O(1) **/
  /**
   约瑟夫环
   状态定义： 设「i, m 问题」的解为 dp[i] ；
   转移方程： 通过以下公式可从 dp[i - 1] 递推得到 dp[i] ；
   dp[i]=(dp[i−1]+m)%i
   初始状态：1, m问题」的解恒为 0 ，即 dp[1] = 0 ；
   返回值： 返回n, m问题」的解dp[n] ；
   **/
  public int lastRemaining(int n, int m) {
    int res=0;
    for(int i=2; i<=n; i++) {
      res = (res + m)%i;
    }
    return res;
  }

}
