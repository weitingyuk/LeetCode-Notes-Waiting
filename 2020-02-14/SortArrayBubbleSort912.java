package Leetcode;

public class SortArrayBubbleSort912 {

  /**
   * Method3: Bubble Sort - V1; Average Time: O(NlogN), The Best Time: O(N), The Worst Time: O(N^2); Space: O(1)  Stability: true
   **/
  public int[] sortArray(int[] nums) {
    bubbleSort(nums, nums.length);
    return nums;
  }
  private void bubbleSort(int[] a, int n) {
    for (int i = n -1; i>0; i--) {
      for (int j = 0; j < i; j++) {
        if (a[j] > a[j + 1]) {
          int tmp = a[j];
          a[j] = a[j + 1];
          a[j + 1] = tmp;
        }
      }
    }
  }

  /**
   * Method3: Bubble Sort - V2; Average Time: O(NlogN), The Best Time: O(N), The Worst Time: O(N^2); Space: O(1)  Stability: true
   **/
  private void bubbleSort2(int[] a, int n) {
    boolean flag = false;
    for (int i = n -1; i>0; i--) {
      flag = false;
      for (int j = 0; j < i; j++) {
        if (a[j] > a[j + 1]) {
          int tmp = a[j];
          a[j] = a[j + 1];
          a[j + 1] = tmp;
          flag = true;
        }
      }
      if(!flag) {
        break;
      }
    }
  }


}
