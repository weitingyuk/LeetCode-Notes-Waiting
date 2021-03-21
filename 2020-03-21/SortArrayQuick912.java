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
  public int[] sortArray(int[] nums) {
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
}
