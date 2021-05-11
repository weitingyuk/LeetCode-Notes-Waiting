package Leetcode;

public class SortArrayByParity905 {

  /*Method: Two Pointers, Time: O(N), Space:O(1)**/
  /**
   定义left和right指针，right指针向前寻找数组中的偶数,当寻找到后，与当前left指针互换数据。
   **/
  public int[] sortArrayByParity(int[] A) {
    int l=0,r =0;
    for(int i=0; i<A.length; i++) {
      if(A[r]%2 == 0) {
        swap(A, l, r);
        l++;
        r++;
      } else {
        r ++;
      }
    }
    return A;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
