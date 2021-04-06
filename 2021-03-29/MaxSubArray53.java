package Leetcode;

public class MaxSubArray53 {
  /*Method : DP, Time: O(N), Space:O(1)**/
  public int maxSubArray(int[] nums) {
    int res = nums[0]; //res是从nums[0]开始，因为是从位置最小的开始
    int pre = 0; //pre是从0开始，因为每次和0对比
    for(int i=0; i< nums.length;i++) {
      pre = Math.max(pre + nums[i] , nums[i]); //如果前边累加后还不如自己本身大，那就把前边的都扔掉，从此自己本身重新开始累加。
      res = Math.max(res, pre);
    }
    return res;
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
