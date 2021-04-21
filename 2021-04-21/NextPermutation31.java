package Leetcode;

public class NextPermutation31 {
  /**Method: Two scan; Time: O(N), Space: O(1) **/
  /**
   1. 需要将一个左边的「较小数」与一个右边的「较大数」交换，以能够让当前排列变大，从而得到下一个排列。
   2. 同时要让这个「较小数」尽量靠右，而「较大数」尽可能小。
   3. 当交换完成后，「较大数」右边的数需要按照升序重新排列。这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小。
   **/
  public void nextPermutation(int[] nums) {
    if(nums == null || nums.length ==0) {
      return;
    }
    int len = nums.length;
    int i=len-2; // i从len-2开始比较
    while(i>=0 && nums[i] >= nums[i+1]) {
      i--;
    }
    if(i>=0) {
      int j=len-1;
      while(j>=0 && nums[i] >= nums[j]){
        j--;
      }
      swap(nums, i, j);
    }
    reverse(nums, i+1, len-1);
  }

  public void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public void reverse(int[] nums, int start, int end) {
    int left = start, right = end;
    while (left < right) {
      swap(nums, left, right);
      left++;
      right--;
    }
  }

}
