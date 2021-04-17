package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyAlmostDuplicate220 {
  /** Method: Bucket Sort, Time: O(N); Space: O(min(N,K))**/
  /**
   思想： 按照元素的大小进行分桶，维护一个滑动窗口内的元素对应的元素。
   对于元素 xx，其影响的区间为 [x - t, x + t]。于是我们可以设定桶的大小为 t + 1。
   如果两个元素同属一个桶，那么这两个元素必然符合条件。
   **/
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    int len = nums.length;
    Map<Long, Long> map = new HashMap<Long, Long>();
    long w = (long) t + 1;
    for (int i = 0; i < len; i++) {
      long id = getID(nums[i], w);
      if (map.containsKey(id)) {
        return true;
      }
      if (map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id - 1)) < w) {
        return true;
      }
      if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) < w) {
        return true;
      }
      map.put(id, (long) nums[i]);
      if (i >= k) {
        map.remove(getID(nums[i - k], w));
      }
    }
    return false;
  }

  public long getID(long x, long w) {
    if (x >= 0) {
      return x / w;
    }
    return (x + 1) / w - 1;
  }

}
