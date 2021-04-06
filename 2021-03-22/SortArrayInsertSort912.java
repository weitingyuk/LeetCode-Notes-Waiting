package Leetcode;

public class SortArrayInsertSort912 {

  /**
   * Method4: Insert Sort; Average Time: O(N^2), The Best Time: O(N), The Worst Time: O(N^2); Space: O(1)  Stability: true
   **/
  public int[] sortArray(int[] a) {
    for(int i=1; i<a.length;i++) {
      int insertNode = a[i];
      int j = i-1;
      for(; j>=0 && insertNode < a[j]; j--) {
        a[j+1] = a[j];
      }
      a[j+1] =insertNode;
    }
    return a;
  }

}
