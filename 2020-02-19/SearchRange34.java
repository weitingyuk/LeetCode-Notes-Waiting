package Leetcode;

public class SearchRange34 {
  /**Method: Binary search; Time: O(logn); Space: O(1) **/
  public int[] searchRange(int[] nums, int target) {
    int startIdx = binarySearch(nums, target, true);
    int endIdx = binarySearch(nums, target, false) - 1;
    if(startIdx <= endIdx && endIdx < nums.length && nums[startIdx] == target && nums[endIdx] == target ) {
      return new int[]{startIdx, endIdx};
    }
    return new int[]{-1, -1};
  }

  private int binarySearch(int[] nums, int target, boolean isLower) {
    int lower = 0, high = nums.length - 1, ans = nums.length;
    while(lower <= high) {
      int mid = lower + (high - lower) / 2;
      if(nums[mid] > target || (isLower && nums[mid] == target)) {
        high = mid -1;
        ans = mid;
      } else {
        lower = mid + 1;
      }
    }
    return ans;
  }
}
