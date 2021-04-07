package Leetcode;

import java.util.LinkedList;

public class SortArrayQuick912 {

  /**
   * Method1: NonRecQuickSort; Average Time: O(NlogN), The Best Time: O(NlogN), The Worst Time: O(N^2); Space: O(H); Stability: false
   **/
  public int[] sortArray1(int[] nums) {
    NonRecQuickSort(nums, 0, nums.length - 1);
    return nums;
  }

  private void NonRecQuickSort(int[] a, int start, int end) {
    LinkedList<Integer> stack = new LinkedList<Integer>();
    if (start < end) {
      stack.push(end);
      stack.push(start);
      while (!stack.isEmpty()) {
        int l = stack.pop();
        int r = stack.pop();
        int index = partition(a, l, r);
        if (l < index - 1) {
          stack.push(index - 1);
          stack.push(l);
        }
        if (r > index + 1) {
          stack.push(r);
          stack.push(index + 1);
        }
      }
    }
  }

  private int partition(int[] a, int start, int end) {
    int pivot = a[start];
    while (start < end) {
      while (start < end && a[end] >= pivot) {
        end--;
      }
      a[start] = a[end];
      while (start < end && a[start] <= pivot) {
        start++;
      }
      a[end] = a[start];
    }
    a[start] = pivot;
    return start;
  }

  /**
   * Method2: RecQuickSort Time: O(NlogN) Space: O(H)
   **/
  public int[] sortArray2(int[] nums) {
    quickSort2(nums, 0, nums.length - 1);
    return nums;
  }
  private void quickSort2(int[] s, int l, int r) {
    if (l < r) {
      int i = l;
      int j = r;
      int pivot = s[l];
      while (i < j) {
        while (i < j && s[j] > pivot) {
          j--;
        }
        if (j > i) {
          s[i++] = s[j];
        }
        while (i < j && s[i] < pivot) {
          i++;
        }
        if (i < j) {
          s[j--] = s[i];
        }
      }
      s[i] = pivot;
      quickSort2(s, l, i - 1);
      quickSort2(s, i + 1, r);
    }
  }

  /** Method3: Quick Sort with Random Piovt; Average Time: O(NLogN); Space: O(1);  Stability: false **/
  /** 优化1： 随机是解决本来就有序的情况，会产生最坏的排序O(N^2)**/
  public int[] sortArray3(int[] a) {
    partition3(a, 0, a.length-1);
    return a;
  }

  private void partition3(int[] a, int l, int r) {
    if(l<r) {
      int i=l,j=r;
      swap(a, l, (int) (Math.random() * (r - l + 1)) + l); //随机快速排序
      int pivot = a[l];
      while(i<j) {
        while(i<j && pivot <= a[j] ){
          j--;
        }
        if(i<j) {
          a[i++] = a[j];
        }
        while(i<j && pivot >= a[i]) {
          i++;
        }
        if(i<j) {
          a[j--] = a[i];
        }
      }
      a[i] = pivot;
      partition(a, l, i-1);
      partition(a, i+1, r);
    }
  }


  /** Method4: Quick Sort with Dual Piovt; Average Time: O(NLogN); Space: O(1);  Stability: false **/
  /** 优化2： 双轴快排： 主要是解决本来有大量重复元素，划分不均匀；**/
  public int[] sortArray4(int[] input){
    dualQuickSort(input, 0, input.length-1);
    return input;
  }
  private void dualQuickSort(int[] input, int lowIndex, int highIndex) {
    if (highIndex<=lowIndex) return;
    int pivot1=input[lowIndex];
    int pivot2=input[highIndex];
    if (pivot1>pivot2){
      swap(input, lowIndex, highIndex);
      pivot1=input[lowIndex];
      pivot2=input[highIndex];
    }
    else if (pivot1==pivot2){
      while (pivot1==pivot2 && lowIndex<highIndex){
        lowIndex++;
        pivot1=input[lowIndex];
      }
    }
    int i=lowIndex+1;
    int lt=lowIndex+1;
    int gt=highIndex-1;

    while (i<=gt){
      if (input[i] < pivot1){
        swap(input, i++, lt++);
      }
      else if (pivot2 < input[i]){
        swap(input, i, gt--);
      }
      else{
        i++;
      }
    }
    swap(input, lowIndex, --lt);
    swap(input, highIndex, ++gt);
    dualQuickSort(input, lowIndex, lt-1);
    dualQuickSort (input, lt+1, gt-1);
    dualQuickSort(input, gt+1, highIndex);
  }


  /** Method5: Quick Sort with 3Way; Average Time: O(NLogN); Space: O(1);  Stability: false **/
  /** 优化3：三轴：进一步优化,把和pivot相同的放在中间**/
  public int[] sortArray5(int[] input){
    sort3Way(input, 0, input.length-1);
    return input;
  }
  public void sort3Way(int[] input, int lowIndex, int highIndex) {
    if (highIndex<=lowIndex) return;
    int lt=lowIndex;
    int gt=highIndex;
    int i=lowIndex+1;
    int pivotIndex=lowIndex;
    int pivotValue=input[pivotIndex];
    while (i<=gt){
      if (input[i] < pivotValue){
        swap(input, i++, lt++);
      }
      else if (pivotValue < input[i]){
        swap(input, i, gt--);
      }
      else{
        i++;
      }
    }
    sort3Way(input, lowIndex, lt-1);
    sort3Way(input, gt+1, highIndex);
  }

  private void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }



}
