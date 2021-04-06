package Leetcode;

public class SortArrayMergeSort912 {
  /** Method6: Merge Sort; Average Time:  O(NlogN), The Best Time:  O(NlogN), The Worst Time:  O(NlogN); Space: O(1)  Stability: true **/
  public int[] sortArray(int[] nums) {
    mergeSort(nums, 0, nums.length-1);
    return nums;
  }
  private void mergeSort(int[] a, int start, int end) {
    if(a == null || start >= end) {     return;  }
    int mid = (start + end) /2;
    mergeSort(a, start, mid);
    mergeSort(a, mid + 1, end);
    merge(a, start, mid, end);
  }
  private void merge(int[] a, int start, int mid, int end) {
    int[] temp = new int[end - start + 1];
    int i = start;
    int j = mid +1;
    int  k =0;
    while(i <= mid && j <= end) {
      if(a[i] <= a[j]) {
        temp[k++] = a[i++];
      } else {
        temp[k++] = a[j++];
      }
    }
    while(i<=mid) {    temp[k++] = a[i++];   }
    while(j <= end) {  temp[k++] = a[j++]; }
    for(i = 0;  i < k; i++) {
      a[start + i] = temp[i];
    }
    temp=null;
  }
}
