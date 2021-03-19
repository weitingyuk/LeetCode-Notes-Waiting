package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring48 {

  /**Method: Double pointer + hash map; Time:O(N); Space:O(N) **/
  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map =  new HashMap<>();
    int i=-1,res=0;
    for(int j=0; j<s.length(); j++){
      char c = s.charAt(j);
      if(map.containsKey(c)) {
        i = Math.max(i, map.get(c));
      }
      map.put(c, j);
      res = Math.max(res, j-i);
    }
    return res;
  }

}
