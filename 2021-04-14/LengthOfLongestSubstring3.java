package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring3 {
/**Method: Double pointer + hash map; Time:O(N); Space:O(N) **/
  /**
   滑动窗口：
   定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
   我们定义不重复子串的开始位置为 start，结束位置为 end
   随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，并更新 start，此时 [start, end] 区间内不存在重复字符
   无论是否更新 start，都会更新其 map 数据结构和结果 res
   **/
  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map =new HashMap<>();
    int start=-1, res =0;
    for(int end=0; end<s.length(); end++){
      char ch = s.charAt(end);
      if(map.containsKey(ch)) {
        start = Math.max(map.get(ch), start);
      }
      map.put(ch, end);
      res = Math.max(end-start, res);
    }
    return res;
  }
}
