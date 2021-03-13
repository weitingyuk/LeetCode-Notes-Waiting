package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

class MyQueue232 {
  /** Method1: two stacks; Time: pop() / peek() - O(N), others-O(1);  Space:O(N);**/
  /**
   * Stack的方法： offer, poll, peek
   */
  private Queue<Integer> stack1;
  private Queue<Integer> stack2;
  public MyQueue232() {
    stack1 = new LinkedList<>();
    stack2 = new LinkedList<>();
  }
  public void push(int x) {
    stack1.offer(x);
  }
  public int pop() {
    while(!stack1.isEmpty()){
      stack2.offer(stack1.poll());
    }
    int res = stack2.poll();
    while(!stack2.isEmpty()){
      stack1.offer(stack2.poll());
    }
    return res;
  }
  public int peek() {
    while(!stack1.isEmpty()){
      stack2.offer(stack1.poll());
    }
    int res = stack2.peek();
    while(!stack2.isEmpty()){
      stack1.offer(stack2.poll());
    }
    return res;
  }
  public boolean empty() {
    return stack1.isEmpty();
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
