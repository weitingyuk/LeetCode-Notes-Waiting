package Leetcode;

import java.util.Arrays;

public class FindDuplicate287 {
  /**Method: Two pointers; Time: O(N)); Space: O(1) **/
  public int findDuplicate(int[] nums) { //对比https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/submissions/， 只有一个重复
    int fast = 0, slow = 0;
    do{
      slow = nums[slow];
      fast = nums[nums[fast]]; //映射 x = nums[x]
    } while(fast != slow);
    slow = 0;
    while(fast != slow) {
      slow = nums[slow];
      fast = nums[fast]; // 第一次相遇以后，后面使用相同的频率前进。
    }
    return slow;
  }
}
