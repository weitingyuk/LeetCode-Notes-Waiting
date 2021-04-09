package Leetcode;

public class MaxArea11 {
  /**Method: Two Pointers; Time:O(N); Space: O(1) **/
  /**
   面积公式：两个指针指向的数字中较小值∗指针之间的距离
   由于水槽的实际高度由两板中的短板决定，则可得面积公式 S(i, j) = min(h[i], h[j]) × (j - i)。
   1. 首先左右指针分别指向数组的左右两端,
   2. 如果我们移动数字较大的那个指针，那么前者「两个指针指向的数字中较小值」不会增加，后者「指针之间的距离」会减小，那么这个乘积会减小。
   3. 所以移动数字较大的那个指针是不合理的。因此，我们移动 数字较小的那个指针。
   **/
  public int maxArea(int[] height) {
    int i = 0;
    int j = height.length-1;
    int res = 0;
    while(i<j) {
      if(height[i] < height[j]) {
        res = Math.max(res, (j-i) * height[i++]);
      } else {
        res = Math.max(res, (j-i) * height[j--]);
      }
    }
    return res;
  }

}
