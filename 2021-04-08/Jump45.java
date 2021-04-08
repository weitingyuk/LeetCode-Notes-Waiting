package Leetcode;

public class Jump45 {

  /**Method: Max Position; Time:O(N); Space: O(1) **/
  public int jump(int[] nums) {
    int len = nums.length;
    int end = 0; //end表示前一步的最大位置
    int maxP = 0;
    int steps = 0;
    for(int i=0; i<len-1; i++) {
      maxP = Math.max(maxP, nums[i] + i);
      if(i == end) { //每次到达最大位置以后，再次更新最大位置
        end = maxP;
        steps++;
      }
    }
    return steps;
  }

}
