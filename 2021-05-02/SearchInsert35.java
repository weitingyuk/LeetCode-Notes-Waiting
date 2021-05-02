package Leetcode;

public class SearchInsert35 {
  /**Method: Binary Search; Time:O(LogN); Space: O(1) **/
  /**
   直接套用二分法，不断用二分法逼近查找第一个大于等于 target 的下标 。
   **/
  public int searchInsert(int[] nums, int target) {
    int n=nums.length;
    int l = 0, r = n-1, res = n;
    while(l<=r) {
      int mid = l + (r-l)/2;
      if(target <= nums[mid]) {
        res = mid;
        r = mid-1;
      } else {
        l = mid+1;
      }
    }
    return res;
  }
}
