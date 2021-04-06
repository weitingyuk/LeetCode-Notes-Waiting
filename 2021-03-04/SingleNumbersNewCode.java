package Leetcode;

public class SingleNumbersNewCode {
  /** Method: XOR； Space: O(1)； Time: O(N)； **/
  public static int[] singleNumbers(int[] nums) {
    int dif = 0;
    for(int num: nums) {
      dif ^= num;
    }
    dif = dif & (-dif);
    int[] group = new int[2];
    for(int num: nums) {
      if((num&dif) != 0) {
        group[0] ^= num;
      } else {
        group[1] ^= num;
      }
    }
    return group;
  }

  public static void main(String[] args) {
    int[] nums = {4,1,4,6};
    int[] res = singleNumbers(nums);
    System.out.println("The result numbers are "+ res[0] + " & " + res[1]);
  }
}
