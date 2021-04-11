package Leetcode;

public class NthUglyNumber264 {
  /*Method: DP, Time: O(N), Space:O(N)**/
  /**
   动态方程 dp[i]=min(dp[p2]*2,dp[p3]*3,dp[p5]*5)
   **/
  public int nthUglyNumber(int n) {
    int[] dp = new int[n];
    dp[0] = 1;
    int p2=0, p3=0, p5=0;
    for(int i=1;i<n;i++) {
      int nums2 = dp[p2]*2, nums3 = dp[p3]*3,  nums5 = dp[p5]*5;
      dp[i] = Math.min(Math.min(nums2, nums3), nums5);
      if(dp[i] == nums2) {
        p2++;
      }
      if(dp[i] == nums3) {
        p3++;
      }
      if(dp[i] == nums5) {
        p5++;
      }
    }
    return dp[n-1];
  }

}
