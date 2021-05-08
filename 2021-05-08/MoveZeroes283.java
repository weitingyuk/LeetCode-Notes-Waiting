package Leetcode;

public class MoveZeroes283 {
  /** Method: Two Pointers; Time: O(N);  Space:O(1);**/
  /**
   左指针左边均为非零数；
   右指针左边直到左指针处均为零。
   因此每次交换，都是将左指针的零与右指针的非零数交换，且非零数的相对顺序并未改变。
   **/
  public void moveZeroes(int[] nums) {
    int len=nums.length, l = 0, r=0;
    while(r<len){
      if(nums[r] != 0){
        swap(nums, r, l);
        l++;
      }
      r++;
    }
  }

  private void swap(int[] nums, int l, int r){
    int temp = nums[l];
    nums[l] = nums[r];
    nums[r] = temp;
  }

}
