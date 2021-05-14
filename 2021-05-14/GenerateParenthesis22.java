package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis22 {
  /*Method: Back Track, Time: O(4^N/EXP(N)), Space:O(N)**/
  /**
   如果左括号数量不大于 nn，我们可以放一个左括号。如果右括号数量小于左括号的数量，我们可以放一个右括号。
   **/
  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<String>();
    backtrack(res, new StringBuilder(), 0, 0, n);
    return res;
  }

  public void backtrack(List<String> res, StringBuilder cur, int open, int close, int max){
    if(cur.length() == max*2) {
      res.add(cur.toString());
      return;
    }
    if(open < max){
      cur.append('(');
      backtrack(res, cur, open+1, close, max);
      cur.deleteCharAt(cur.length() -1);
    }
    if(close < open) {
      cur.append(')');
      backtrack(res, cur, open, close+1, max);
      cur.deleteCharAt(cur.length()-1);
    }
  }
}
