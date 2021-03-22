package Leetcode;

public class SortArraySelectSort912 {
  /** Method5: Select Sort; Average Time: O(N^2), The Best Time: O(N^2), The Worst Time: O(N^2); Space: O(1)  Stability: false **/
  public int[] sortArray(int[] a) {
    int i,j,min;
    for(i=0;i<a.length;i++) {
      min = i;
      for(j=i+1; j<a.length;j++) {
        if(a[j] < a[min]) {
          min = j;
        }
      }
      swap(a, i, min);
    }
    return a;
  }

  private void swap(int[] nums , int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }
}
