package Leetcode;

public class JumpGame55 {
  /**Method: Max Position; Time:O(N); Space: O(1) **/
  public boolean canJump(int[] nums) {
    int maxP = 0;
    int len = nums.length;
    for(int i =0; i<len; i++ ) {
      if(i<=maxP) {
        maxP = Math.max(maxP, nums[i] + i);
        if(maxP >= len-1) {
          return true;
        }
      }
    }
    return false;
  }
}
