package Leetcode;

public class SortColors75 {
  /**Method: Two Pointers; Time: O(N);  Space:O(1);**/
  public void sortColors(int[] nums) {
    int zero = -1, one =0, two =nums.length;
    while(one<two) {
      if(nums[one] ==0 ){
        swap(nums, ++zero, one++);
      } else if(nums[one] == 2) {
        swap(nums, --two, one);
      } else {
        one++;
      }
    }

  }

  private void swap(int[] nums, int s, int e) {
    int t = nums[s];
    nums[s] = nums[e];
    nums[e] = t;
  }

}
