package Leetcode;

import java.util.Random;

public class Pick398 {
  /*Method: Reservoir Sampling, Time: O(N), Space:O(1)**/
  /** ：对第i个元素，以k/i的概率更新取值，以1 - k/i的概率保留原值。 */
  int[] nums;
  public Pick398(int[] nums) {
    this.nums = nums;
  }

  public int pick(int target) {
    Random r = new Random();
    int count=0, res=0;
    for(int i=0; i< nums.length; i++){
      if(target == nums[i]){
        if(r.nextInt(++count) == 0){ // 取0的概率为1/i
          res = i;
        }
      }
    }
    return res;
  }
}
