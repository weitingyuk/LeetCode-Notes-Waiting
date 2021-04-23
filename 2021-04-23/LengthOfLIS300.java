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

  /** Method2: Greedy + BinSearch; Time:O(NLogN); Space: O(N) **/
  /**
   维护一个数组 tails[i] ，表示长度为 i 的最长上升子序列的末尾元素的最小值
   设当前已求出的最长上升子序列的长度为len（初始时为 11），从前往后遍历数组nums，在遍历到nums[i] 时：
   如果 nums[i]>tails[len] ，则直接加入到 tails 数组末尾，并更新 len=len+1；
   否则，在 tails 数组中二分查找，找到第一个比nums[i] 小的数 d[k] ，并更新 tails[k + 1] = nums[i]。
   **/
  public int lengthOfLIS2(int[] nums) {
    int[] tails = new int[nums.length];
    int res = 0;
    for(int num:nums){
      int i=0, j = res;
      while(i<j) {
        int m = (i+j)/2;
        if(tails[m] < num) {
          i = m+1;
        } else {
          j=m;
        }
      }
      tails[i] = num;
      if(res == j) {
        res++;
      }
    }
    return res;
  }

}
