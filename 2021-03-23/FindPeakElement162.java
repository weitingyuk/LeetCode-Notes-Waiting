package Leetcode;

public class FindPeakElement162 {
  /**Method: Binary search; Time: O(log(n)); Space: O(1) **/
  public int findPeakElement(int[] nums) {
    int s = 0, e = nums.length-1;
    while(s<e) {
      int mid = s+(e-s)/2;
      if(nums[mid] > nums[mid+1]) { // x和它的下一个值比较，判峰值是在左边还是右边
        e = mid; // mid可能就是峰值，所以e=mid
      } else {
        s = mid+1;
      }
    }
    return s;
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
