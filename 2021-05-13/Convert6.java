package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Convert6 {
  /*Method: Print by line, Time: O(N), Space:O(N)**/
  /**
   按顺序遍历字符串 s；
   res[i] += c： 把每个字符 c 填入对应行 s_i
   i += flag： 更新当前字符 c 对应的行索引；
   flag = - flag： 在达到 Z 字形转折点时，执行反向。
   **/
  public String convert(String s, int numRows) {
    if(numRows < 2) {
      return s;
    }
    List<StringBuilder> rows = new ArrayList<StringBuilder>();
    for(int i=0; i<numRows; i++) {
      rows.add(new StringBuilder());
    }
    int i=0, flag = -1;
    for(char c: s.toCharArray()) {
      rows.get(i).append(c);
      if(i==0 || i==numRows-1){
        flag = -flag;
      }
      i += flag;
    }
    StringBuilder res = new StringBuilder();
    for(StringBuilder row: rows ) {
      res.append(row);
    }
    return res.toString();
  }

}
