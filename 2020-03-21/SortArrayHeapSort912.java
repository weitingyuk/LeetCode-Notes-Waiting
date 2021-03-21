package Leetcode;

public class SortArrayHeapSort912 {
  /**
   * Method2: HeapSort; Average Time: O(NlogN), The Best Time: O(N), The Worst Time: O(N^2); Space: O(1)  Stability: false
   **/
  public int[] sortArray(int[] nums) {
    int len = nums.length;
    for(int i=len/2-1; i>=0;i--) {
      maxHeapDown(nums, i, len-1);
    }
    for(int i=len-1;i>0;i--) {
      swap(nums, 0, i);
      maxHeapDown(nums, 0, i-1);
    }
    return nums;
  }

  private void maxHeapDown(int[] nums, int start, int end) {
    int c = start;
    int l=2*c+1;
    int temp = nums[c];
    for(; l<=end; c=l, l=2*l+1) {
      if(l<end && nums[l] < nums[l+1]) {
        l = l+1;
      }
      if(temp >= nums[l]) { //如果高层值大于低层，就跳过
        break;
      }
      nums[c] = nums[l];
      nums[l]= temp; // 这里是temp下沉
    }
  }

  private void swap(int[] nums , int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }

}
