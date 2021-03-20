package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import sun.jvm.hotspot.utilities.Interval;

public class EmployeeFreeTime759 {

  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    int open =0, close =1;
    List<int[]> events = new ArrayList<>();
    for(List<Interval> e: schedule) {
      for(Interval i: e) {
        events.add(new int[]{i.start, open});
        events.add(new int[]{i.end, close});
      }
    }
    Collections.sort(events, (a,b) -> a[0] == b[0] ? a[1] -b[1] : a[0] -b[0]);
    List<Interval> ans = new ArrayList<>();

    int pre = -1, bal=0;
    for(int[] event : events) {
      if(bal ==0 && pre >0) {
        ans.add(new Interval(pre, event[0]));
      }
      bal += event[1] ==open?1:-1;
      pre = event[0];
    }

    return ans;
  }

  class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
      start = _start;
      end = _end;
    }
  };
}
