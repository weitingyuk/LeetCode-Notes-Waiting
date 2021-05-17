package Leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class EvalRPN150 {
  /*Method: Stack, Time: O(N), Space:O(N)**/
  public int evalRPN(String[] tokens) {
    Deque<Integer> stack = new LinkedList<Integer>();
    int n=tokens.length;
    for(int i=0; i<n;i++){
      String token = tokens[i];
      if(isNumber(token)) {
        stack.push(Integer.parseInt(token));
      } else {
        int num2 = stack.pop();
        int num1 = stack.pop();
        switch(token) {
          case "+":
            stack.push(num1 + num2);
            break;
          case "-":
            stack.push(num1-num2);
            break;
          case "*":
            stack.push(num1 * num2);
            break;
          case "/":
            stack.push(num1/ num2);
            break;
          default:
        }
      }
    }
    return stack.pop();
  }

  private boolean isNumber(String token) {
    return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
  }

}
