package Leetcode;

public class RotateSearch33 {
  /**Method: Binary search; Time: O(log(n)); Space: O(1) **/
  public int search(int[] nums, int target) {
    int len = nums.length;

    int s = 0, e= len-1;
    while(s<=e) {
      int mid = s+(e-s)/2;
      if(nums[mid] == target) {
        return mid;
      }
      if(nums[0] <= nums[mid]) { //先判断旋转是在mid左边还是右边
        if(nums[0] <= target && target < nums[mid]) {
          e = mid -1;
        } else {
          s = mid +1;
        }
      } else {
        if(nums[mid] < target && target <= nums[e]) {
          s = mid + 1;
        } else {
          e = mid - 1;
        }
      }
    }
    return -1;
  }
}
