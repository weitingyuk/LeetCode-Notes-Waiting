package Leetcode;

import java.util.Stack;

public class SimplifyPath71 {

  /**Method: Stack; Time: O(N); Space: O(N) **/
  /**
   1.定义一个辅助栈;
   2.先把字符串以"/"为分隔符分割成数组,此时数组有"路径"、""、"."、".."这四种情况;
   3.遍历数组,当s[i].equals("..")并且栈不空时pop,当!s[i].equals("") && !s[i].equals(".") && !s[i].equals(".."),即s[i]是路径入栈;
   4.栈空,返回"/",栈非空,StringBuilder返回;
   **/
  public String simplifyPath(String path) {
    String[] s = path.split("/");
    Stack<String> stack = new Stack<>();

    for (int i = 0; i < s.length; i++) {
      if (!stack.isEmpty() && s[i].equals(".."))
        stack.pop();
      else if (!s[i].equals("") && !s[i].equals(".") && !s[i].equals(".."))
        stack.push(s[i]);
    }
    if (stack.isEmpty())
      return "/";

    StringBuffer res = new StringBuffer();
    for (int i = 0; i < stack.size(); i++) {
      res.append("/" + stack.get(i));
    }
    return res.toString();
  }
}
