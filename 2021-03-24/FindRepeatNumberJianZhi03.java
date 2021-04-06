package Leetcode;

public class FindRepeatNumberJianZhi03 {
  /** Method: in place sort to get the nums[i] == i; Time: O(N) ; Space: O(1) **/
  public int findRepeatNumber(int[] nums) { //对比https://leetcode-cn.com/problems/find-the-duplicate-number/submissions/ ：有多个重复，找一个就可以
    for(int i=0;i<nums.length;i++) {
      while(i!=nums[i]) {
        if(nums[i] == nums[nums[i]]) {
          return nums[i];
        }
        swap(nums, i, nums[i]);
      }
    }
    return -1;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
