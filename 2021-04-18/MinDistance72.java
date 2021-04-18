package Leetcode;

public class MinDistance72 {
  /**Method: DP; Time: O(m*n); Space: O(m*n) **/
  /**
   dp[i][j] 代表 word1 到 i 位置转换成 word2 到 j 位置需要最少步数
   当 word1[i] == word2[j]，dp[i][j] = dp[i-1][j-1]；
   当 word1[i] != word2[j]，dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
   其中，dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。
   **/
  public int minDistance(String word1, String word2) {
    if(word1 == null || word2 == null) {
      return 0;
    }
    int m = word1.length();
    int n = word2.length();
    int[][] dp = new int[m+1][n+1];
    for(int i=0; i<=m; i++) {
      dp[i][0] = i;
    }
    for(int j=0; j<=n;j++) {
      dp[0][j] = j;
    }
    for(int i=1;i<=m; i++) {
      for(int j=1; j<=n; j++) {
        if(word1.charAt(i-1)==word2.charAt(j-1)){
          dp[i][j] = dp[i-1][j-1];
        }else{
          dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
        }
      }
    }
    return dp[m][n];
  }

}
