package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindContinuousSequence57 {
  /*Method: Two Pointers, Time: O(target), Space:O(1)**/
  /**
   初始化： 左边界 i = 1，右边界 j = 2，元素和 s = 3，结果列表 res；循环; 当i≥j 时跳出；
   当 s > target 时： 向右移动左边界 i = i + 1，并更新元素和 s ；
   当 s < target 时： 向右移动右边界 j = j + 1，并更新元素和 s ；
   当 s = target时： 记录连续整数序列，并向右移动左边界 i = i + 1；
   返回值： 返回结果列表 res；
   **/
  public int[][] findContinuousSequence(int target) {
    int i = 1, j =2, s = 3; // 初始化的值
    List<int[]> res = new ArrayList<>();
    while(i<j) {
      if(s == target) {
        int[] list = new int[j-i+1]; // new a array
        for(int x = i; x<=j; x++) {
          list[x-i] = x;
        }
        res.add(list);
      }
      if(s < target) {
        j++;
        s+=j;
      } else { // if s >= target
        s-=i; // need minus to i firstly, then i++;
        i++;
      }
    }
    return res.toArray(new int[res.size()][]); // to array
  }

}
