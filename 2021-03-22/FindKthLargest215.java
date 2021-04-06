package Leetcode;

import java.util.Random;

public class FindKthLargest215 {
  /**Method1: Partition of Quick Sort; Time: O(N), The Worst Time: O(N^2);; Space:O(logN) **/
  public int findKthLargest1(int[] nums, int k) {
    int len = nums.length;
    int target = len-k; // 1. target是最大的k, target = len-k
    int low =0, high = len-1;
    while(true) {
      int i=partition(nums, low, high);  // 2. 找到i以后相当于二分了
      if(i == target) {
        return nums[i];
      } else if(i < target){
        low =  i+1;
      } else{
        high = i-1;
      }
    }
  }

  private int partition(int[] nums, int s, int e) {
    int i=s, j=e;
    int pivot = nums[i];
    while(i<j) {
      while(i<j && pivot < nums[j]) {
        j--;
      }
      if(i<j) {
        nums[i++] = nums[j];
      }
      while(i<j && pivot > nums[i]) {
        i++;
      }
      if(i<j) {
        nums[j--] = nums[i];
      }
    }
    nums[i] = pivot;
    return i;
  }


  /**Method2: Heap Sort; Time: O(KlogN);; Space:O(logN) **/
  public int findKthLargest2(int[] nums, int k) {
    int len= nums.length;
    for(int i=len/2-1;i>=0;i--) {
      maxDown(nums, i, len-1);
    }
    for(int i=len-1; i>=len-k+1;i--) { //K+1次对换，找到顶就可以
      swap(nums, i, 0);
      maxDown(nums, 0, i-1);
    }
    return nums[0];
  }

  private void maxDown(int[] nums, int s, int e) {
    int c = s;
    int l = c*2+1;
    int temp = nums[c];
    for(; l<= e; c=l, l=l*2+1) {
      if(l<e && nums[l] < nums[l+1]) {
        l = l+1;
      }
      if(temp >= nums[l] ) {
        break;
      }
      nums[c] = nums[l];
      nums[l] = temp;
    }
  }

  private void swap(int[] nums, int low, int high) {
    int temp = nums[low];
    nums[low] = nums[high];
    nums[high] = temp;
  }

}
