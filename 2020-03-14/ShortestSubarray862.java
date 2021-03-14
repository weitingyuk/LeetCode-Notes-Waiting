package Leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class ShortestSubarray862 {
  /** Method: sliding window; Time:O(n); Space:o(n) **/
  public int shortestSubarray(int[] A, int K) {
    int res = Integer.MAX_VALUE;
    Deque<Integer> dq = new LinkedList<Integer>();
    int len = A.length;
    int[] preSum = new int[len+1];
    for(int i=0;i<len;i++) {
      preSum[i+1] = preSum[i] + A[i];
    }
    for(int i=0; i<= len; i++) {
      if(i != 0) {
        while(!dq.isEmpty() && preSum[dq.peekLast()] >= preSum[i]) { //如果当前前缀和小于前一个数的前缀和
          dq.pollLast();
        }
        while(!dq.isEmpty() && preSum[i] - preSum[dq.peekFirst()] >= K) {
          res = Math.min(res, i-dq.pollFirst());
        }
      }
      dq.addLast(i);
    }
    return res == Integer.MAX_VALUE? -1: res;
  }

}
