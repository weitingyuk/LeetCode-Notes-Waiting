package Leetcode;

public class MaxProfit123 {
  /** Method: DP; Time: O(N);  Space:O(1);**/
  /**
   * 1. 刚开始未进行过任何操作；
   2. buy1： 只进行过一次买操作；
   3. sell1： 进行了一次买操作和一次卖操作，即完成了一笔交易；
   4. buy2： 在完成了一笔交易的前提下，进行了第二次买操作；
   5. sell2： 完成了全部两笔交易
   */
  public int maxProfit(int[] prices) {
    int n = prices.length;
    int buy1 = -prices[0], sell1 = 0;
    int buy2 = -prices[0], sell2 = 0;
    for(int i=0; i < n; i++) {
      buy1 = Math.max(buy1, -prices[i]);
      sell1 = Math.max(sell1, buy1 + prices[i]);
      buy2 = Math.max(buy2, sell1-prices[i]);
      sell2 = Math.max(sell2, buy2 + prices[i]);
    }
    return sell2;
  }

}
