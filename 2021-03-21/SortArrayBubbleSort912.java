package Leetcode;

public class SortArrayBubbleSort912 {

  /**
   * Method3: Bubble Sort - V1; Average Time: O(NlogN), The Best Time: O(N), The Worst Time: O(N^2); Space: O(1)  Stability: true
   **/
  public int[] sortArray(int[] nums) {
    int len = nums.length;
    for(int i =len-1;i>=0;i--) {
      for(int j=0; j<i; j++) {
        if(nums[j] > nums[j+1]) {
          swap(nums, j, j+1);
        }
      }
    }
    return nums;
  }

  private void swap(int[] nums , int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }

  /**
   * Method3: Bubble Sort - V2; Average Time: O(NlogN), The Best Time: O(N), The Worst Time: O(N^2); Space: O(1)  Stability: true
   **/
  public int[] sortArray2(int[] nums) {
    int len = nums.length;
    boolean flag = false;
    for(int i =len-1;i>=0;i--) {
      flag = false;
      for(int j=0; j<i; j++) {
        if(nums[j] > nums[j+1]) {
          swap(nums, j, j+1);
          flag = true;
        }
      }
      if(!flag) {
        break;
      }
    }
    return nums;
  }


}
