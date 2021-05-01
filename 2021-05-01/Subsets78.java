package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {
  /**Method: Iteration; Time: O(N*2^N); Space: O(N) **/
  /**
   每个数字 nums[i]的状态可能有两种，即「在子集中」和「不在子集中」。我们用 1 表示「在子集中」，0 表示不在子集中
   **/
  public List<List<Integer>> subsets(int[] nums) {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    int n = nums.length;
    for(int m=0;m < (1<<n) ; m++) {
      list.clear();
      for(int i=0; i<n; i++) {
        if((m & (1<<i)) != 0) {
          list.add(nums[i]);
        }
      }
      res.add(new ArrayList<Integer>(list));
    }
    return res;
  }

}
