package Leetcode;

public class Trap42 {

  /**Method: Two Pointers; Time: O(N);  Space:O(1);**/
  /**
   当两个指针没有相遇时，进行如下操作：
   使用 height[left] 和 height[right]的值更新 leftMax和 rightMax 的值；
   如果 height[left]<height[right]，则必有 leftMax<rightMax，下标 left 处能接的雨水量等于 leftMax−height[left]，将下标 left 处能接的雨水量加到能接的雨水总量，然后将 eft 加 11（即向右移动一位）；
   如果 height[left]≥height[right]，则必有leftMax≥rightMax，下标 right 处能接的雨水量等于 rightMax−height[right]，将下标 right 处能接的雨水量加到能接的雨水总量，然后将 right 减 1（即向左移动一位）。
   **/
  public int trap(int[] height) {
    int ans = 0;
    int left =0, right=height.length-1;
    int leftMax = 0, rightMax = 0;
    while(left < right) {
      leftMax = Math.max(leftMax, height[left]);
      rightMax = Math.max(rightMax, height[right]);
      if(height[left] < height[right]) {
        ans += leftMax -height[left];
        ++left;
      } else{
        ans += rightMax-height[right];
        --right;
      }
    }
    return ans;
  }
}
