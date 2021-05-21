package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SnapshotArray1146 {
  /*Method: Tree Map, Time: O(LogN), Space:O(N)**/
  //每一个Map记录的是当前下标位置的值的变动，<版本号，新值>
  List<TreeMap<Integer, Integer>> arr = new ArrayList<>();
  int snap = 0;
  public SnapshotArray1146(int length) {
    for(int i=0; i<length; i++) {
      arr.add(new TreeMap<>());
    }
  }

  public void set(int index, int val) {
    //在index处放入此次版本更新的值
    TreeMap<Integer, Integer> map = arr.get(index);
    map.put(snap, val);
  }

  public int snap() {
    return snap++;
  }

  public int get(int index, int snap_id) {
    TreeMap<Integer, Integer> map = arr.get(index);
    //寻找snap_id版本前，最后一次更新的值
    Integer key = map.floorKey(snap_id);
    return key == null ? 0: map.get(key);
  }
}
