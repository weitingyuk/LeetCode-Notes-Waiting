package Leetcode;

public class SortArrayByParityII922 {
  /*Method: Two Pointers, Time: O(N), Space:O(1)**/
  public int[] sortArrayByParityII(int[] nums) {
    int len = nums.length; // A[i]为偶数， A[j]为偶数指针
    for(int i=0, j=1; i< len; i+=2) {
      if(nums[i] %2 == 1) { //如果 A[i] 为奇数
        while(nums[j] % 2 ==1) { //不断地向前移动 j（每次移动两个单位）
          j+=2;
        }
        swap(nums, i, j); //直到遇见下一个偶数,i=奇数，j=偶数，交换
      }
    }
    return nums;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
