package Leetcode;

public class SearchRange34 {
  /**Method: Binary search; Time: O(logn); Space: O(1) **/
  public int[] searchRange(int[] nums, int target) {
    int start = find(nums, -1, nums.length, target-0.5)+1; //target - 0.5找到的是上一个元素的最后位置，所以要+1
    int end = find(nums, -1, nums.length, target+0.5);
    if(end >= start) {
      return new int[] {start, end};
    }
    return new int[]{-1, -1};
  }

  private int find(int[] nums, int start, int end, double target) {
    if(end - start <=1) {
      return start;
    }
    int mid= start +(end -start) /2;
    if(nums[mid] > target) {
      return find(nums, start, mid, target);
    } else{
      return find(nums, mid, end, target);
    }
  }
}
