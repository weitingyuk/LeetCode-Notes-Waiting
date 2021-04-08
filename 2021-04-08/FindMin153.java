package Leetcode;

public class FindMin153 {
  /**Method: BinarySearch; Time:O(LogN); Space: O(1) **/
  /**
   思路：把待搜索区间分成两个部分：
   1. 一定不存在 目标元素的区间：下一轮搜索的时候，不用考虑它；
   2. 可能存在 目标元素的区间：下一轮搜索的时候，需要考虑它。
   **/
  public int findMin(int[] nums) {
    int l = 0;
    int h = nums.length-1;
    while(l<h) {
      int mid = l+(h-l)/2;
      if(nums[mid] < nums[h]) { // 说明最低点在左边
        h = mid;
      } else {
        l=mid+1;
      }
    }
    return nums[l];
  }

}
