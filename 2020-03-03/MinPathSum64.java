package Leetcode;

public class MinPathSum64 {
  /* Method: DP , Time: O(M*N), Space:O(M*N)**/
  public int minPathSum(int[][] grid) {
    int len = grid[0].length;
    int[] dp = new int[len];
    dp[0] = grid[0][0];
    for(int i = 1; i< len; i++) {
      dp[i] = dp[i-1] + grid[0][i];
    }

    for (int i = 1; i < grid.length; i++) {
      dp[0] = grid[i][0] + dp[0];
      for (int j = 1; j < len; j++){
        dp[j] = Math.min(dp[j-1]+grid[i][j], dp[j]+grid[i][j]);
      }
    }
    return dp[len-1];
  }


}
