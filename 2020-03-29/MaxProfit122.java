package Leetcode;

public class MaxProfit122 {

  /*Method 1: DP, Time: O(N), Space:O(1)**/
  public int maxProfit(int[] prices) {
    int len = prices.length;
    int dp0 = 0;
    int dp1 = -prices[0]; //一开始是买入，就是负值
    for(int i=1;i<len;i++) {
      dp0 = Math.max(dp0, dp1 + prices[i]); //  dp0 的转移方程，如果这一天交易完后手里没有股票：前一天已经没有股票，即 dp[i−1][0]，或者前一天结束的时候手里持有一支股票, 并卖出，并获得prices[i] 的收益
      dp1 = Math.max(dp1, dp0 - prices[i]); //  dp1 的转移方程，如果这一天交易完后手里没有股票：可能的转移状态为前一天已经持有一支股票，即dp[i−1][1]，或者前一天结束时还没有股票，即dp[i−1][0]，这时候我们要将其买入，并减少prices[i] 的收益
    }
    return Math.max(dp0, dp1);
  }

  /*Method 2: Greedy, Time: O(N), Space:O(1)**/
  public int maxProfit2(int[] prices) {
    int len = prices.length;
    int res = 0;
    for(int i=1;i<len;i++) {
      res += Math.max(0, prices[i] - prices[i-1]); //把所有的上坡全部收集到，一定是利益最大化的
    }
    return res;
  }
}
