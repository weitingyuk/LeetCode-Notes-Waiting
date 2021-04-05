package Leetcode;

public class RemoveElement27 {
  /**Method: Two pointers; Time:O(N); Space: O(1) **/
  /**
   思路：双指针
   指针1： count指向已经移除了val以后的index
   指针2： i表当前数组遍历的值
   **/
  public int removeElement(int[] nums, int val) {
    int count =0;
    for(int i=0;i<nums.length; i++) {
      if(nums[i] != val) {
        nums[count++] = nums[i];
      }
    }
    return count;
  }

}
