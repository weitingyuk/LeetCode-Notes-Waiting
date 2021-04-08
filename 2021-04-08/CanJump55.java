package Leetcode;

public class CanJump55 {
  /**Method: Max Position; Time:O(N); Space: O(1) **/
  public boolean canJump(int[] nums) {
    int len = nums.length;
    int maxP =0; //表示可达的范围
    for(int i=0; i<len; i++) {
      if(i<=maxP) { //
        maxP=Math.max(maxP,nums[i]+i);//取最大范围
        if(maxP>=len-1) {
          return true;
        }
      }

    }
    return false;
  }

}
