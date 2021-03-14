package Leetcode;

public class XorGame810 {
  /**
   思路：分两种情况：奇数和偶数位
   如果初始异或和就是 0, 先手直接赢了。
   胜负其实和数组长度有关，如果长度为偶数，先手必胜，否则必败。
   **/
  public boolean xorGame(int[] nums) {
    int res = 0;
    for(int i=0;i<nums.length; i++) {
      res ^= nums[i];
    }
    return nums.length %2 ==0 || res ==0;
  }
}
