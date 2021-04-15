package Leetcode;

import java.util.Arrays;

public class Rob213 {
  /**Method: DP; Time: O(N), Space: O(1) **/
  /**
   把此环状排列房间问题约化为两个单排排列房间子问题：
   在不偷窃第一个房子的情况下（即 nums[1:]，最大金额是 p1
   在不偷窃最后一个房子的情况下（即 nums[:n-1]），最大金额是 p2
   综合偷窃最大金额： 为以上两种情况的较大值，即 max(p1,p2)
   **/
  public int rob(int[] nums) {
    int len = nums.length;
    if(len ==0) {
      return 0;
    }
    if(len == 1) {
      return nums[0];
    }
    if(len == 2) {
      return Math.max(nums[0], nums[1]);
    }
    return Math.max(robRange(Arrays.copyOfRange(nums, 0, len-1)), robRange(
        Arrays.copyOfRange(nums, 1, len)));
  }
  private int robRange(int[] nums){ //dp[n] 只与 dp[n−1] 和 dp[n−2] 有关系，因此我们可以设两个变量 cur和 pre 交替记录，将空间复杂度降到 O(1)。
    int pre = 0;
    int cur =0;
    for(int num:nums) {
      int temp = cur;
      cur = Math.max(pre+num, temp);
      pre = temp;
    }
    return cur;
  }

}
