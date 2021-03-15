package Leetcode;

public class MaxSubArray53 {
  /*Method : DP, Time: O(N), Space:O(1)**/
  public int maxSubArray(int[] nums) {
    int pre = 0;
    int maxRes = nums[0];
    for(int i= 0;i< nums.length; i++) {
      pre = Math.max(pre + nums[i], nums[i]);
      maxRes = Math.max(pre, maxRes);
    }
    return maxRes;
  }


  /**两次求最大值：1.前缀和 VS 0； 2.当前的和 VS 之前的和 **/
  public int maxSubArray1(int[] nums) {
    int res = nums[0];
    for(int i=1;i<nums.length;i++) {
      nums[i] += Math.max(nums[i-1], 0);
      res = Math.max(res, nums[i]);
    }
    return res;
  }
}
