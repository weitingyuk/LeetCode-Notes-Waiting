package Leetcode;

import java.util.Arrays;

public class CoinChange322 {
  /**Method: DP; Time: O(SN);  Space:O(N);**/
  /**
   时间复杂度：O(SN)，其中 S 是金额，N 是面额数
   定义 dp(i)为组成金额 i 所需最少的硬币数量，假设在计算 dp(i) 之前，我们已经计算出 dp(0)-dp(i-1) 的答案。 则 dp(i) 对应的转移方程应为Math.min(dp[i], dp[i - coins[j]] + 1);
   **/
  public int coinChange(int[] coins, int amount) {
    int max = amount + 1;
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, max);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] <= i) {
          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
      }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }

}
