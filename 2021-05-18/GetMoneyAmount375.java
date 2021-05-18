package Leetcode;

public class GetMoneyAmount375 {
  /*Method: DP, Time: O(N^3), Space:O(N^2)**/
  /**
   只需要从(i+(len−1)/2,j) 中选第一个数就可以了，其中 len 是当前区间的长度
   **/
  public int getMoneyAmount(int n) {
    int[][] dp = new int[n+1][n+1];
    for(int len = 2; len<=n; len++) {
      for(int start = 1; start <= n-len+1; start++) {
        int minRes = Integer.MAX_VALUE;
        for(int i = start +(len-1)/2; i <start+len-1;i++) {
          int res = i + Math.max(dp[start][i-1],dp[i+1][start + len -1]);
          minRes = Math.min(res, minRes);
        }
        dp[start][start + len - 1] = minRes;
      }
    }
    return dp[1][n];
  }

}
