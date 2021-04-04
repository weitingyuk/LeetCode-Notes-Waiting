package Leetcode;

import java.util.Stack;

public class DecodeString394 {

  /**Method: Stacks; Time: O(N), Space: O(1) **/
  /**
   思路： 两个栈分别保存遇到']'之前的值
   stack1保存： 此前的临时string结果 res 至栈
   stack2保存： 此前的临时次数结果 multi 至栈
   当 c 为数字时，将数字字符转化为数字 multi，用于后续倍数计算；
   当 c 为字母时，在 res 尾部添加 c；
   当 c 为 [ 时，将当前 multi 和 res 入栈，并分别置空置 0：
   当 c 为 ] 时，stack 出栈，拼接字符串 res = last_res + cur_multi * res
   **/
  public String decodeString(String s) {
    StringBuilder res = new StringBuilder();
    int multi = 0;
    Stack<Integer> multiStack = new Stack<>(); //stack1 store the previous times
    Stack<String> resStack = new Stack<>(); //stack2 store the previous String
    for(Character c: s.toCharArray()) { //注意：s.toCharArray()
      if(c.equals('[')) {
        resStack.push(res.toString());
        multiStack.add(multi);
        multi = 0;
        res = new StringBuilder();
      } else if(c.equals(']')){
        int curMulti = multiStack.pop();
        StringBuilder temp = new StringBuilder();
        for(int i=0; i< curMulti;i++) {
          temp.append(res);
        }
        res = new StringBuilder(resStack.pop() + temp.toString()); //注意： 这里把新老值都更新到res
      } else if(c>='0' && c <='9') {
        multi = multi * 10 + (c-'0');
      } else {
        res.append(c);
      }
    }
    return res.toString();
  }

}
