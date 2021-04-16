package Leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class GetLeastNumbers40 {
  /**Method: Heap Sort; Time: O(NLogK), Space: O(K) **/
  public int[] getLeastNumbers(int[] arr, int k) {
    if (k == 0 || arr.length == 0) {
      return new int[0];
    }
    // 默认是小根堆，实现大根堆需要重写一下比较器。
    Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
    for (int num: arr) {
      if (pq.size() < k) {
        pq.offer(num);
      } else if (pq.size() == 0 || num < pq.peek()) {
        pq.poll();
        pq.offer(num);
      }
    }

    // 返回堆中的元素
    int[] res = new int[pq.size()];
    int idx = 0;
    for(int num: pq) {
      res[idx++] = num;
    }
    return res;
  }

}
