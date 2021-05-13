package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Partition131 {
  /*Method:DFS + Back Tracing, Time: O(N * 2^N), Space:O(N^2)**/
  /**
   假设我们当前搜索到字符串的第 i 个字符，且 [0..i−1] 位置的所有字符已经被分割成若干个回文串，并且分割结果被放入了答案数组 ans 中，那么我们就需要枚举下一个回文串的右边界 j，使得 s[i..j] 是一个回文串。
   **/
  int[][] dp;
  List<List<String>> res = new ArrayList<List<String>>();
  List<String> list = new ArrayList<String>();
  int n;
  public List<List<String>> partition(String s) {
    n = s.length();
    dp = new int[n][n];

    dfs(s, 0);
    return res;
  }

  public void dfs(String s, int i) {
    if (i == n) {
      res.add(new ArrayList<String>(list));
      return;
    }
    for (int j = i; j < n; ++j) {
      if (isPalindrome(s, i, j) == 1) {
        list.add(s.substring(i, j + 1));
        dfs(s, j + 1);
        list.remove(list.size() - 1);
      }
    }
  }
  // 记忆化搜索中，f[i][j] = 0 表示未搜索，1 表示是回文串，-1 表示不是回文串
  public int isPalindrome(String s, int i, int j) {
    if (dp[i][j] != 0) {
      return dp[i][j];
    }
    if (i >= j) {
      dp[i][j] = 1;
    } else if (s.charAt(i) == s.charAt(j)) {
      dp[i][j] = isPalindrome(s, i + 1, j - 1);
    } else {
      dp[i][j] = -1;
    }
    return dp[i][j];
  }

}
