package Leetcode;

public class SingleNumber136 {

  /**
   * 任何数和 00 做异或运算，结果仍然是原来的数。
   * 任何数和其自身做异或运算，结果是 0。
   * 异或运算满足交换律和结合律。
   */
  public int singleNumber(int[] nums) {
    int res =0;
    for(int i: nums){
      res ^= i;
    }
    return res;
  }
}
