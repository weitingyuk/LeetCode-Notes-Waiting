package Leetcode;

public class ReversePairsNewCode51 {
  /*Method : Merge sort, Time: O(NLogN), Space:O(N)**/
  public int reversePairs(int[] nums) {
    int len = nums.length;
    if(len < 2) {
      return 0;
    }
    int[] copy = new int[len];
    for(int i=0; i< len; i++) {
      copy[i] = nums[i];
    }
    int[] temp = new int[len];
    return reversePairs(copy, 0, len - 1, temp);
  }

  public int reversePairs(int[] nums, int left, int right, int[] temp) {
    if(right == left) {
      return 0;
    }
    int mid = left + (right - left) / 2;
    int leftPairs = reversePairs(nums, left, mid, temp);
    int rightPairs = reversePairs(nums, mid + 1, right, temp);
    if(nums[mid] < nums[mid + 1]) {
      return leftPairs + rightPairs;
    }
    int crossPairs = mergeAndCount(nums, left, mid, right, temp);
    return leftPairs + rightPairs + crossPairs;
  }

  private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
    for (int i = left; i <= right; i++) {
      temp[i] = nums[i];
    }
    int i = left;
    int j = mid + 1;
    int count = 0;
    for (int k = left; k <= right; k++) {

      if (i == mid + 1) {
        nums[k] = temp[j];
        j++;
      } else if (j == right + 1) {
        nums[k] = temp[i];
        i++;
      } else if (temp[i] <= temp[j]) {
        nums[k] = temp[i];
        i++;
      } else {
        nums[k] = temp[j];
        j++;
        count += (mid - i + 1);
      }
    }
    return count;
  }
}
