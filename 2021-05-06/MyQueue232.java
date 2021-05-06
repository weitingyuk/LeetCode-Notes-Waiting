package Leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class MyQueue232 {
  /** Method1: two stacks; Time: pop() / peek() - O(N), others-O(1);  Space:O(N);**/
  /**
   * Stack的方法： offer, poll, peek
   */
  private Deque<Integer> inStack; //Deque
  private Deque<Integer> outStack;

  public MyQueue232() {
    inStack = new LinkedList<>();
    outStack = new LinkedList<>();
  }
  /**Method1: two stacks; Time: pop()-O(N), others-O(1);  Space:O(1);**/
  public void push(int x) {
    inStack.push(x);
  }

  public int pop() {
    if(outStack.isEmpty()) {
      in2out();
    }

    return outStack.pop();
  }

  public int peek() {
    if(outStack.isEmpty()) {
      in2out();
    }
    return outStack.peek();
  }

  public boolean empty() {
    return outStack.isEmpty() && inStack.isEmpty();
  }

  private void in2out() {
    while(!inStack.isEmpty()) {
      outStack.push(inStack.pop());
    }
  }
}

class MyQueue {
  /**Method2: add a front; Time: pop()-O(N), others-O(1);  Space:all methods-O(N);**/
  private Queue<Integer> stack1;
  private Queue<Integer> stack2;
  private int front;
  public MyQueue() {
    stack1 = new LinkedList<>();
    stack2 = new LinkedList<>();
  }
  public void push(int x) {
    if(stack1.isEmpty()){
      front = x;
    }
    stack1.offer(x);
  }
  public int pop() {
    if(stack2.isEmpty()){
      while(!stack1.isEmpty()){
        stack2.offer(stack1.poll());
      }
    }
    return stack2.poll();
  }
  public int peek() {
    while(stack2.isEmpty()){
      return front;
    }
    return stack2.peek();
  }
  public boolean empty() {
    return stack1.isEmpty() && stack2.isEmpty();
  }
}
