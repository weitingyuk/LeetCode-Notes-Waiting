package Leetcode;

public class MedianLintCode80 {
  /**
   * @param nums: A list of integers
   * @return: An integer denotes the middle number of the array
   */
  /**Method: Partition of Quick Sort;Amortized Time: O(N); Space:O(1) **/
  public int median(int[] nums) {
    return partition(nums, 0, nums.length-1, nums.length - nums.length/2);
  }

  private int partition(int[] nums, int start, int end, int k) {
    int i = start;
    int j = end;
    int pivot = nums[i];
    while(i< j) {
      while(i<j && nums[j] >= pivot ) {
        j--;
      }
      nums[i] = nums[j];
      while(i<j && nums[i] <= pivot) {
        i++;
      }
      nums[j] = nums[i];
    }
    nums[i] = pivot;
    if(i-start == k-1) {
      return nums[i];
    }
    else if(i-start > k-1){
      return partition(nums,start,i-1,k);
    }
    else {
      return partition(nums,i+1,end,k-(i-start+1));
    }
  }
}
