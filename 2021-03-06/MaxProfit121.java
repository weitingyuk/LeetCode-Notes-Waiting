package Leetcode;

public class MaxProfit121 {
  /*Method: DP, Time: O(N), Space:O(1)**/
  public int maxProfit(int[] prices) {
    int minPrice = Integer.MAX_VALUE;
    int maxValue = 0;
    for(int i=0;i<prices.length; i++) {
      if(prices[i]<minPrice) {
        minPrice = prices[i];
      } else if(prices[i] - minPrice > maxValue){
        maxValue = prices[i] - minPrice;
      }
    }
    return maxValue;
  }
}
