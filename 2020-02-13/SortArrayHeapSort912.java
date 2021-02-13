package Leetcode;

public class SortArrayHeapSort912 {
  /**
   * Method2: HeapSort Time: O(NlogN) Space: O(H)  Stability: false
   **/
  public int[] sortArray(int[] nums) {
    heapSortAsc(nums, nums.length);
    return nums;
  }
  private void heapSortAsc(int[] a, int n) {
    int i,tmp;
    for (i = n / 2 - 1; i >= 0; i--) {maxHeapDown(a, i, n-1);}
    for (i = n - 1; i > 0; i--) {
      tmp = a[0];
      a[0] = a[i];
      a[i] = tmp;
      maxHeapDown(a, 0, i-1);
    }
  }
  private void maxHeapDown(int[] a, int start, int end) {
    int c = start;
    int l = 2*c + 1;
    int tmp = a[c];
    for (; l <= end; c=l,l=2*l+1) {
      if ( l < end && a[l] < a[l+1])
        l++;
      if (tmp >= a[l])
        break;
      else {
        a[c] = a[l];
        a[l]= tmp;
      }
    }
  }

}
