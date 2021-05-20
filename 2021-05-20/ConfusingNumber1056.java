package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class ConfusingNumber1056 {

  /*Method: Map, Time: O(N), Space:O(M) -M is the number of confusing**/
  /**
   思路：
   1.输入转字符数组，方便反转判断
   2.遍历数组，同时生成翻转字符串，判断是否0,1,6,8,9. 否直接返回false
   3. 判断是否与翻转后的字符串一致
   **/
  public boolean confusingNumber(int n) {
    Map<String, String> map = new HashMap<>();
    map.put("0", "0");
    map.put("1", "1");
    map.put("6", "9");
    map.put("8", "8");
    map.put("9", "6");
    String str = String.valueOf(n);
    String res = "";
    for(char c: str.toCharArray()) {
      if(!map.containsKey(String.valueOf(c))) {
        return false;
      }
      res = res+ map.get(String.valueOf(c));
    }
    return !new StringBuffer(str).reverse().toString().equalsIgnoreCase(res);
  }
}
