package Leetcode;

public class FindPeakElement162 {
  /**Method: Binary search; Time: O(log(n)); Space: O(1) **/
  public int findPeakElement(int[] nums) {
    int start = 0;
    int end = nums.length -1;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if(nums[mid] > nums[mid +1]) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }
    return start;
  }

  /**Method2: Binary search with recursive; Time: O(log(n)); Space: O(log(n)) **/
  public int findPeakElement2(int[] nums) {
    return binarySearch(nums, 0, nums.length -1);
  }

  private int binarySearch (int[] nums, int start, int end) {
    if(start == end) {
      return start;
    }
    int mid = start + (end - start)/2;
    if(nums[mid] > nums[mid +1]) {
      return binarySearch(nums, start, mid);
    }
    return binarySearch(nums, mid+1, end);
  }
}
