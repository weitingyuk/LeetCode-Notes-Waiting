package Leetcode;

public class SingleNumber136 {

  /** Method: XOR; Time: O(N);  Space:O(1);**/
  /**
   任何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a。
   任何数和其自身做异或运算，结果是 0，即 a⊕a=0。
   **/
  public int singleNumber(int[] nums) {
    int res = 0;
    for(int i: nums) {
      res ^= i;
    }
    return res;
  }
}
