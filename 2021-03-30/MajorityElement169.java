package Leetcode;

public class MajorityElement169 {
  /*Method: Boyer-Moore, Time: O(N), Space:O(1)**/
  /**
   遍历数组，如果 times 的值为 0，我们先将nums[i] 的值赋予res，随后我们判断nums[i]：
   如果nums[i] 与 res 相等，那么计数器 times 的值增加 1；
   如果nums[i] 与 res 不等，那么计数器 times 的值减少 1。
   **/
  public int majorityElement(int[] nums) {
    int times = 0;
    int res =0;
    for(int i=0; i<nums.length;i++) {
      if(times == 0) {
        res = nums[i];
      }
      if(nums[i] == res) {
        times ++;
      } else {
        times --;
      }
    }
    return res;
  }

}
