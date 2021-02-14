package Leetcode;

public class SortArrayInsertSort912 {

  /**
   * Method4: Insert Sort; Average Time: O(N^2), The Best Time: O(N), The Worst Time: O(N^2); Space: O(1)  Stability: true
   **/
  public int[] sortArray(int[] nums) {
    insertSort(nums, nums.length);
    return nums;
  }
  private void insertSort(int[] a, int n) {
    int i, j, insertNote;
    for (i = 1; i < a.length; i++) {
      insertNote = a[i];
      j = i - 1;
      while (j >= 0 && insertNote < a[j]) {
        a[j + 1] = a[j];
        j--;
      }
      a[j + 1] = insertNote;
    }
  }

}
