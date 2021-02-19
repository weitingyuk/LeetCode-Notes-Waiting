package Leetcode;

public class RotateSearch33 {
  /**Method: Binary search; Time: O(log(n)); Space: O(1) **/
  public int search(int[] nums, int target) {
    int n = nums.length;
    if(n == 0) {
      return -1;
    }
    if(n == 1) {
      return nums[0] == target ? 0: -1;
    }
    int start = 0;
    int end = n -1;
    while (start <= end) {
      int mid = start + (end - start) /2;
      if(nums[mid] == target) {
        return mid;
      }
      if(nums[0] <= nums[mid]) {
        if(target < nums[mid] && nums[0] <= target) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else{
        if(target <= nums[n-1] && nums[mid] < target) {
          start = mid + 1;
        } else {
          end = mid - 1;
        }
      }
    }
    return -1;
  }
}
