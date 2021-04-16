package Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent347 {
  /**Method: Heap Sort; Time: O(NLogK), Space: O(K) **/
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int num: nums){
      map.put(num, map.getOrDefault(num, 0) +1);
    }
    // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
    PriorityQueue<int[]> pq = new PriorityQueue<>((v1, v2) -> v1[1]-v2[1]);
    for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
      int key = entry.getKey(), val = entry.getValue();
      if(pq.size() == k) {
        if(pq.peek()[1] < val) {
          pq.poll();
          pq.offer(new int[]{key, val});
        }

      } else {
        pq.offer(new int[]{key, val});
      }
    }
    int[] res = new int[k];
    for(int i=0; i<k;i++){
      res[i] = pq.poll()[0];
    }
    return res;
  }

}
