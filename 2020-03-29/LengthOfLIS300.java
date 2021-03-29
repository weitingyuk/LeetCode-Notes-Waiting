package Leetcode;

import java.util.Arrays;

public class LengthOfLIS300 {
  /**Method:DP; Time:O(N^2); Space:O(N) **/
  public int lengthOfLIS(int[] nums) {
    if(nums == null) {
      return 0;
    }
    int len = nums.length;
    int[] dp = new int[len]; //dp[i] 表示：以 nums[i] 结尾 的「上升子序列」的长度。
    Arrays.fill(dp, 1);
    int res = 1;
    for(int i=0;i<len;i++) {
      for(int j=0; j<i; j++) {
        if(nums[i] > nums[j] ) {
          dp[i] = Math.max(dp[i], dp[j]+1); //只要 nums[i] 严格大于在它位置之前的某个数，那么 nums[i] 就可以接在这个数后面形成一个更长的上升子序列。
        }
      }
      res= Math.max(res, dp[i]);
    }
    return res;
  }

}
