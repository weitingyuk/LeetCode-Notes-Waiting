package Leetcode;

public class FindRepeatNumberJianZhi03 {
  /** Method: in place sort to get the nums[i] == i; Time: O(N) ; Space: O(1) **/
  public int findRepeatNumber(int[] nums) {
    for(int i =0; i< nums.length;i++) {
      while( i != nums[i]) {
        if(nums[i] == nums[nums[i]]) {
          return nums[i];
        }
        int temp = nums[nums[i]];
        nums[nums[i]] = nums[i];
        nums[i] = temp;
      }

    }
    return -1;
  }
}
