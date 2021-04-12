package Leetcode;

import java.util.Arrays;

public class LargestNumber179 {

  /*Method: Comparator, Time: O(N), Space:O(N)**/
  /**
   思路：
   1. 数字数组转换成字符串数组，
   2. 排序
   3. 拼接
   4. string等于00的时候处理
   **/
  public String largestNumber(int[] nums) {
    int len = nums.length;
    String[] strs = new String[len];

    for(int i=0;i<len;i++) {
      strs[i] = String.valueOf(nums[i]);
    }
    Arrays.sort(strs, (a,b) -> { // 排序,主要排序顺序
      return (b+a).compareTo(a+b);
    });
    StringBuilder res = new StringBuilder();
    for(int i=0;i<len;i++) {
      res.append(strs[i]);
    }
    return res.charAt(0) == '0' ? "0" : res.toString(); //对"00" 做特殊处理
  }
}
