package Leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinMeetingRooms253 {
  /**Method: PriorityQueue; Time:O(NLogN); Space: O(N) **/
  /**
   按照 开始时间 对会议进行排序。
   初始化一个新的 最小堆，将第一个会议的结束时间加入到堆中。我们只需要记录会议的结束时间，告诉我们什么时候房间会空。
   对每个会议，检查堆的最小元素（即堆顶部的房间）是否空闲。
   若房间空闲，则从堆顶拿出该元素，将其改为我们处理的会议的结束时间，加回到堆中。
   若房间不空闲。开新房间，并加入到堆中。
   处理完所有会议后，堆的大小即为开的房间数量。这就是容纳这些会议需要的最小房间数。
   **/
  public int minMeetingRooms(int[][] intervals) {
    if(intervals == null || intervals.length ==0) {
      return 0;
    }
    PriorityQueue<Integer> all = new PriorityQueue<Integer>(intervals.length, (a,b) -> a-b);
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    all.add(intervals[0][1]);
    for(int i=1; i<intervals.length; i++) {
      if(intervals[i][0] >= all.peek()) {
        all.poll();
      }
      all.add(intervals[i][1]);
    }
    return all.size();
  }


}
