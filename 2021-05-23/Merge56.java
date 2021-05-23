package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge56 {

  /**Method: sort the start and merge; Time: O(NLogN);  Space:O(N);**/
  /**
   1. 先按照区间起始位置排序
   2. 遍历区间
   3. 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置， 则不合并，直接将当前区间加入结果数组。
   4. 反之将当前区间合并至结果数组的最后区间
   **/
  public int[][] merge(int[][] intervals) {
    if(intervals == null ||intervals.length==0) {
      return new int[0][0];
    }
    Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
    List<int[]> res = new ArrayList<>();
    int idx = 0;
    for(int i=0; i< intervals.length; i++) {
      int start = intervals[i][0], end = intervals[i][1];
      if(idx ==0 || res.get(idx-1)[1] < start) {
        res.add(new int[]{start, end});
        idx++;
      } else{
        res.get(idx-1)[1] = Math.max(end, res.get(idx-1)[1]);
      }
    }
    return res.toArray(new int[idx][]);
  }
}
