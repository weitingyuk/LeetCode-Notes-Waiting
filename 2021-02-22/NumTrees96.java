package Leetcode;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class NumTrees96 {
  /**Method: DP; Time: O(N^2); Space: O(N) **/
  public int numTrees(int n) {
    int[] dp = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;
    for(int i=2;i<=n;i++) {
      for (int j = 1; j<= i;j++) {
        dp[i] += dp[j-1] * dp[i-j];
      }
    }
    return dp[n];
  }
}
