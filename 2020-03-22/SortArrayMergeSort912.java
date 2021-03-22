package Leetcode;

public class SortArrayMergeSort912 {
  /** Method6: Merge Sort; Average Time:  O(NlogN), The Best Time:  O(NlogN), The Worst Time:  O(NlogN); Space: O(1)  Stability: true **/
  public int[] sortArray(int[] nums) {
    mergeSort(nums, 0, nums.length-1);
    return nums;
  }

  private void mergeSort(int[] nums, int s, int e) {
    if(nums==null || s>=e) {
      return;
    }
    int mid = s+ (e-s)/2; //先递归merge子数组，再merge大的数组
    mergeSort(nums, s, mid);
    mergeSort(nums, mid+1, e);
    merge(nums, s, e, mid);
  }

  private void merge(int[] nums, int s, int e, int mid) {
    int[] temp = new int[e-s+1]; //申请临时数组
    int i=s, j=mid+1, k=0;
    while(i<=mid && j<=e) {
      if(nums[i] <= nums[j]) {
        temp[k++] = nums[i++];
      } else {
        temp[k++] = nums[j++];
      }
    }
    while(i<=mid) {
      temp[k++] = nums[i++];
    }
    while(j<=e) {
      temp[k++] = nums[j++];
    }
    for (i=0; i< k; i++) {
      nums[s+i] = temp[i];
    }
  }
}
