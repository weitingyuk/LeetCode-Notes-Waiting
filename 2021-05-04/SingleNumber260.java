package Leetcode;

public class SingleNumber260 {
  /**Method:Grouping for XOR operation; Time:O(N); Space: O(1) **/
  /**
   先对所有数字进行一次异或，得到两个出现一次的数字的异或值。
   在异或结果中找到任意为 1 的位。
   根据这一位对所有的数字进行分组。
   在每个组内进行异或操作，得到两个数字。
   **/
  public int[] singleNumber(int[] nums) {
    int res = 0;
    for(int n:nums){
      res ^= n;
    }
    int div = 1;
    while((div & res) == 0) {
      div <<= 1;
    }
    int a=0,b=0;
    for(int n:nums) {
      if((div & n) !=0) {
        a ^= n;
      } else {
        b ^= n;
      }
    }
    return new int[]{a,b};
  }

}
