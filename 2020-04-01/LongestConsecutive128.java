package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive128 {

  /*Method: Hash set, Time: O(N), Space:O(N)**/
  /**
   用set去重
   用set的contains方法判断是否包含比x小一的数，没有就从x开始
   用set的contains方法循环判断是否包含比x大一的数据，有就增加len
   **/
  public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>(); //去重
    for(int n: nums) {
      set.add(n);
    }
    int res = 0;
    for(int n: set) {
      if(!set.contains(n-1)) {  //如果没有比它小一个的数据
        int curNum = n;
        int len = 1;
        while(set.contains(curNum+1)) { //就一直往后找连续数组
          len ++;
          curNum ++;
        }
        res = Math.max(res, len);
      }
    }
    return res;
  }

}
