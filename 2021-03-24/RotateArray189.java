package Leetcode;

public class RotateArray189 {
  /**Method: Reverse array; Time: O(N); Space: O(1) **/
  public void rotate(int[] nums, int k) {
    int len = nums.length;
    k =  k% len; //防止k为超大值
    reverse(nums, 0, len-k);
    reverse(nums, len-k, len);
    reverse(nums, 0, len);
  }

  private void reverse(int[] nums, int s, int e) {
    int i = s, j =e-1;
    while(i<j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
      i++;
      j--;
    }
  }
}
