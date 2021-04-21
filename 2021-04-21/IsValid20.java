package Leetcode;

import java.util.Stack;

public class IsValid20 {
  /**Method: Stack; Time: O(N), Space: O(N) **/
  public boolean isValid(String s) {
    if(s.isEmpty())
      return true;
    Stack<Character> stack=new Stack<Character>();
    for(char c:s.toCharArray()){
      if(c=='(')
        stack.push(')');
      else if(c=='{')
        stack.push('}');
      else if(c=='[')
        stack.push(']');
      else if(stack.empty()||c!=stack.pop())
        return false;
    }
    return stack.empty();
  }

}
