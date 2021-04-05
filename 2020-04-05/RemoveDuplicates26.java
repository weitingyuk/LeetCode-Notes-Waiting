package Leetcode;

public class RemoveDuplicates26 {

  /**Method: Two pointers; Time:O(N); Space: O(1) **/
  /**
   思路：双指针
   两个指针 i 和 j, i 是慢指针，而 j 是快指针。只要 nums[i] = nums[j]，我们就增加 j 以跳过重复项。
   当我们遇到 nums[j] !=nums[i], 把它nums[j]的值复制到 nums[i + 1]。
   **/
  public int removeDuplicates(int[] nums) {
    if(nums == null || nums.length == 0){
      return 0;
    }
    int i = 0;
    for(int j=1; j< nums.length;j++){
      if(nums[i] != nums[j]) {
        i++; //因为i从0开始，j从1开始
        nums[i] = nums[j];
      }
    }
    return i+1; //因为i从0开始的
  }

}
