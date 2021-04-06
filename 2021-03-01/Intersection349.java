package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class Intersection349 {
  /*Method : Two Sets, Time: O(M+N), Space:O(M+N)**/
  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set1 = new HashSet<Integer>();
    Set<Integer> set2 = new HashSet<Integer>();
    for(int num: nums1) {
      set1.add(num);
    }
    for(int num:nums2) {
      set2.add(num);
    }
    return intersection(set1, set2);
  }

  public int[] intersection(Set<Integer> set1, Set<Integer> set2) {
    if(set1.size() > set2.size()) {
      return intersection(set2, set1);
    }
    Set<Integer> resSet = new HashSet<>();
    for(int num: set1) {
      if(set2.contains(num)) {
        resSet.add(num);
      }
    }
    int[] res = new int[resSet.size()];
    int index = 0;
    for (int num : resSet) {
      res[index++] = num;
    }
    return res;
  }

}
