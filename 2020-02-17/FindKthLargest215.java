package Leetcode;

import java.util.Random;

public class FindKthLargest215 {
  /**Method1: Partition of Quick Sort; Time: O(N), The Worst Time: O(N^2);; Space:O(logN) **/
  Random random = new Random();
  public int findKthLargest1(int[] nums, int k) {
    return randomPartition(nums, 0, nums.length-1, nums.length - k);
  }
  private int randomPartition(int[] nums, int low, int high, int index) {
    int randomK =  low + random.nextInt(high - low +1);
    swap(nums, randomK, high);
    int partitionIndex = partition(nums, low, high);
    if(partitionIndex == index) {
      return nums[partitionIndex];
    } else {
      return partitionIndex < index ? randomPartition(nums, partitionIndex + 1, high, index) : randomPartition(nums, low, partitionIndex -1, index);
    }
  }
  private int partition (int[] nums, int low, int high) {
    int x = nums[high];
    int i = low -1;
    for (int m = low; m< high; m++) {   if(nums[m] < x) { swap(nums, m, ++i); } }
    swap(nums, i+1, high);
    return i+1;
  }
  private void swap(int[] nums, int low, int high) {
    int temp = nums[low];
    nums[low] = nums[high];
    nums[high] = temp;
  }

  /**Method2: Heap Sort; Time: O(NlogN);; Space:O(logN) **/
  public int findKthLargest2(int[] nums, int k) {
    int heapSize = nums.length;
    int numsLen = nums.length;
    buildMaxHeap(nums, heapSize);
    for(int i = numsLen -1; i>=numsLen-k+1; i--) {
      swap(nums, 0, i);
      maxHeapify(nums, 0, --heapSize);
    }
    return nums[0];
  }
  private void buildMaxHeap (int[] nums, int heapSize) {
    for(int i = heapSize/2; i >=0; i--) {
      maxHeapify(nums, i, heapSize);
    }
  }
  private void maxHeapify (int[] nums, int i ,int heapSize) {
    int left = i * 2 +1, right = i*2+2, largest = i;
    if(left < heapSize && nums[left] >nums[largest] ) {
      largest = left;
    }
    if(right < heapSize && nums[right] > nums[largest]) {
      largest = right;
    }
    if(i != largest) {
      swap (nums, i, largest);
      maxHeapify(nums, largest, heapSize);
    }
  }

}
