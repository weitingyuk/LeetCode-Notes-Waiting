package Leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MinWindow76 {
  /**Method:sliding window; Time:O(C * sLen + tLen); Space: O(C) - Length of String **/
  /**

   有两个指针，一个用于「延伸」现有窗口的 r 指针，和一个用于「收缩」窗口的 l 指针。
   在任意时刻，只有一个指针运动，而另一个保持静止。
   我们在 s 上滑动窗口，通过移动 r 指针不断扩张窗口。
   当窗口包含 t 全部所需的字符后，如果能收缩，我们就收缩窗口直到得到最小窗口。
   这里 t 中可能出现重复的字符，所以我们要记录字符的个数。
   **/
  Map<Character, Integer> origin = new HashMap<>();
  Map<Character, Integer> window = new HashMap<>();
  public String minWindow(String s, String t) {
    int tLen = t.length();
    int sLen = s.length();
    for(int i=0; i<tLen; i++) {
      char c = t.charAt(i);
      origin.put(c, origin.getOrDefault(c, 0) + 1);
    }
    int l=0, r=-1;
    int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;

    while(r<sLen) {
      ++r;
      if(r < sLen && origin.containsKey(s.charAt(r))) {
        window.put(s.charAt(r), window.getOrDefault(s.charAt(r), 0) + 1);
      }
      while(check() && l<=r) {
        if(r-l+1 < len) {
          len = r-l+1;
          ansL = l;
          ansR = l+len;
        }
        if(origin.containsKey(s.charAt(l))) {
          window.put(s.charAt(l), window.getOrDefault(s.charAt(l), 0) - 1);
        }
        ++l;
      }
    }
    return ansL == -1? "" :s.substring(ansL, ansR);
  }
  private boolean check() {
    Iterator iter = origin.entrySet().iterator();
    while(iter.hasNext()) {
      Map.Entry entry = (Map.Entry) iter.next();
      if(window.getOrDefault((Character) entry.getKey(), 0) < (Integer)entry.getValue()) {
        return false;
      }
    }
    return true;
  }

}
