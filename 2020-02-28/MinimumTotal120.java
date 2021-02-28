package Leetcode;

import java.util.List;

public class MinimumTotal120 {
  /*Method : DP + FromDownToUp, Time: O(N^2), Space:O(N^2)**/
  public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    int[][] dp = new int[n][n];
    for(int i =0; i< n; i++) {
      dp[n-1][i] = triangle.get(n-1).get(i);
    }
    for(int i =n - 2; i >= 0 ;i--){
      for(int j = 0 ;j <i+1;j++){
        dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
      }
    }
    return dp[0][0];
  }

  
}
