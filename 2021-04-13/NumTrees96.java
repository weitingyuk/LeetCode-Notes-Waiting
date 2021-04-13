package Leetcode;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class NumTrees96 {
  /**Method: DP; Time: O(N^2); Space: O(N) **/
  /**
   原问题可以分解成规模较小的两个子问题
   DP(i,n)=DP(i−1) * DP(n−i)
   **/
  public int numTrees(int n) {
    int[] dp = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;
    for(int i = 2; i <= n; i++) {
      for(int j=1; j<=i; j++) {
        dp[i] += dp[j-1] * dp[i-j]; //以i为区分，分两边，每次都是乘法
      }
    }
    return dp[n];
  }
}
