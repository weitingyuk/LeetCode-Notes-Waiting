package Leetcode;

public class LongestCommonSubsequence1143 {
  /**Method: DP; Time: O(N*M); Space: O(N*M) **/
  public int longestCommonSubsequence(String text1, String text2) {
    int l1 = text1.length();
    int l2 = text2.length();
    int[][] dp = new int[l1+1][l2+1];

    for(int i = 0; i< l1; i++) {
      for(int j=0; j<l2; j++) {
        char c1= text1.charAt(i);
        char c2 = text2.charAt(j);
        if(c1 == c2) {
          dp[i+1][j+1] = dp[i][j]+1;
        } else{
          dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
        }
      }
    }
    return dp[l1][l2];
  }
}
