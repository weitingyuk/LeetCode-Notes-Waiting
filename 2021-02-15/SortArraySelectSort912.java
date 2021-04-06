package Leetcode;

public class SortArraySelectSort912 {
  /** Method5: Select Sort; Average Time: O(N^2), The Best Time: O(N^2), The Worst Time: O(N^2); Space: O(1)  Stability: false **/
  public int[] sortArray(int[] nums) {
    selectSort(nums, nums.length);
    return nums;
  }
  private void selectSort(int[] a, int n) {
    int i, j, min;
    for (i = 0; i < a.length; i++) {
      min = i;
      for(j = i+1; j <n; j++) {
        if(a[j] < a[min]) {
          min = j;
        }
      }
      if(min != i) {
        int temp = a[i];
        a[i] = a[min];
        a[min] = temp;
      }
    }
  }
}
