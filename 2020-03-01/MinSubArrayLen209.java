package Leetcode;

public class MinSubArrayLen209 {

  /*Method : Double pointer in the same direction, Time: O(N), Space:O(1)**/
  public int minSubArrayLen(int target, int[] nums) {
    int sumi = 0;
    int sumj = 0;
    int minLen = Integer.MAX_VALUE;
    int i =0 ;
    for(int j=0; j< nums.length;j++) {
      sumj += nums[j];
      int curVal = sumj - sumi;
      while(curVal >= target) {
        sumi += nums[i];
        i++;
        curVal = sumj - sumi;
      }
      if(sumj >= target) {
        minLen = Math.min(minLen, j-i+2);
      }
    }
    if(minLen == Integer.MAX_VALUE) {
      return 0;
    }
    return minLen;
  }

}
