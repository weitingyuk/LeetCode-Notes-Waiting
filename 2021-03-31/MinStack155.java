package Leetcode;

import java.util.Stack;

public class MinStack155 {
  /*Method: Two stack, Time: O(1), Space:O(N)**/
  /**
   注意不是要自己实现栈，目标是常数时间内检索到最小值
   **/
  Stack<Integer> stack;
  Stack<Integer> minStack;
  /** initialize your data structure here. */
  public MinStack155() {
    stack = new Stack<>();
    minStack = new Stack<>();
    minStack.push(Integer.MAX_VALUE);
  }

  public void push(int val) {
    stack.push(val);
    minStack.push(Math.min(minStack.peek(), val)); //minStack提前灌入MAX_VALUE，这样peek就不会为空
  }

  public void pop() {
    stack.pop();
    minStack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }

}
