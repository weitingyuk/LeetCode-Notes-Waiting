package Leetcode;

public class UniquePaths62 {
  /** Method: DP; Time: O(N*M); Space: O(Min(N,M)) **/
  public int uniquePaths(int m, int n) {
    if(m ==0 || n == 0) {
      return 0;
    }
    if(m>n) {
      return uniquePaths(n, m);
    }
    int[] dp = new int[m];
    for(int i=0; i<m; i++) {
      dp[i] = 1;
    }
    for(int j=1; j<n; j++) {
      for(int i=1; i<m; i++) {
        dp[i] = dp[i] +dp[i-1];
      }
    }
    return dp[m-1];
  }
}
