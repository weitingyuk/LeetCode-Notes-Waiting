package Leetcode;

public class IsMatch10Re {
  /**Method:DP; Time: O(MN); Space:O(MN) **/
  /**
   用 f[i][j] 表示 s 的前 i 个字符与 p 中的前 j 个字符是否能够匹配
   1. 如果p[j]是一个小写字母; 如果 s[i]与 p[j]不相同，那么无法进行匹配；否则我们可以匹配两个字符串的最后一个字符，完整的匹配结果取决于两个字符串前面的部分。
   2. 如果p[j]是 *，那么就表示我们可以对 p 的第 j-1 个字符匹配任意自然数次。
   3. 在任意情况下，只要 p[j] 是 .，那么 p[j] 一定成功匹配 s 中的任意一个小写字母。
   **/
  public boolean isMatch(String s, String p) {
    int m = s.length();
    int n= p.length();

    boolean[][] dp = new boolean[m+1][n+1];
    dp[0][0] = true;

    for(int i=0; i<= m; i++) {
      for(int j=1; j<=n; j++) {
        if(p.charAt(j-1) == '*') { //如果当前 j 指向的字符为 '*'，把类似 'a*', 'b*' 等的当成整体看待。

          dp[i][j] = dp[i][j-2];
          if(matches(s, p, i, j-1)) {
            dp[i][j] = dp[i][j] || dp[i-1][j];
            // 1. 可以只把 i 前移一位，而不丢弃 'b*', 转化为子问题 f[i-1][j];
            // 2.也可以选择让 'b*' 不再进行匹配，把 'b*' 丢弃。转化为子问题 f[i][j-2];
          }
        } else {
          if(matches(s,p,i,j)) {
            dp[i][j] = dp[i-1][j-1];
          }
        }
      }
    }
    return dp[m][n];
  }

  private boolean matches(String s, String p, int i, int j) {
    if(i==0){
      return false;
    }
    if(p.charAt(j-1) == '.') {
      return true;
    }
    return s.charAt(i-1) == p.charAt(j-1);
  }

}
