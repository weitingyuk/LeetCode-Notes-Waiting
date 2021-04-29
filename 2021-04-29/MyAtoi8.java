package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class MyAtoi8 {
  /**Method: State Machine; Time: O(N); Space:O(1) **/
  /**
   状态机的有四个状态：start， signed， inNumber, end
   对于每个字符串，获取其状态
   **/
  public int myAtoi(String str) {
    Automation automation = new Automation();
    int length = str.length();
    for(int i =0; i<length; i++) {
      automation.get(str.charAt(i));
    }
    return (int) (automation.sign * automation.ans);
  }

  class Automation{
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>() {
      {
        put("start", new String[]{"start", "signed", "inNumber", "end"});
        put("signed", new String[]{"end", "end", "inNumber", "end"});
        put("inNumber", new String[]{"end", "end", "inNumber", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
      }
    };

    public void get(char c) {
      state = table.get(state)[getCol(c)];
      if("inNumber".equals(state)) {
        ans = ans * 10 + c - '0';
        ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
      } else if("signed".equals(state)) {
        sign = c == '+' ? 1 : -1;
      }
    }

    private int getCol(char c) {
      if(c == ' ') {
        return 0;
      }
      if(c == '+' || c == '-') {
        return 1;
      }
      if(Character.isDigit(c)) {
        return 2;
      }
      return 3;
    }
  }

}
