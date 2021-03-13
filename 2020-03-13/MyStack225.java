package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack225 {

  /** Method: two queues; Time: push() - O(N), others-O(1);  Space:O(N);**/
  /**
   * Queue的方法： offer, poll, peek
   */
  Queue<Integer> q1;
  Queue<Integer> q2;
  /** Initialize your data structure here. */
  public MyStack225() {
    q1 = new LinkedList<>();
    q2 = new LinkedList<>();
  }

  /** Push element x onto stack. */
  public void push(int x) {
    q2.offer(x);
    while(!q1.isEmpty()) {
      q2.offer(q1.poll());
    }
    Queue temp = q2;
    q2 = q1;
    q1 = temp;
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    return q1.poll();
  }

  /** Get the top element. */
  public int top() {
    return q1.peek();
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return q1.isEmpty();
  }

  /** Method: one queue; Time: push() - O(N), others-O(1);  Space:O(N);**/
  class MyStack {
    Queue<Integer> q;
    /** Initialize your data structure here. */
    public MyStack() {
      q = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
      int n = q.size();
      q.offer(x);
      for(int i=0; i<n; i++) {
        q.offer(q.poll());
      }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
      return q.poll();
    }

    /** Get the top element. */
    public int top() {
      return q.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
      return q.isEmpty();
    }
  }

}
