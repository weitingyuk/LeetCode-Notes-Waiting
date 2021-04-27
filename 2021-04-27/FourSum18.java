package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FourSum18 {

  /** Method: Use hashMap to store <Integer, List<int[]>; Time: O(N^2) - O(N^3); Space: O(N) **/
  public List<List<Integer>> fourSum(int[] num, int target) {
    Arrays.sort(num);

    Map<Integer, List<int[]>> twoSumMap = new HashMap<>();
    Set<List<Integer>> res = new HashSet<>();

    for (int i = 0; i < num.length; i++) {
      if (i > 1 && num[i] == num[i - 2]) {
        continue;
      }

      for (int j = i + 1; j < num.length; j++) {
        if (j > i + 2 && num[j] == num[j - 2]) {
          continue;
        }
        if (twoSumMap.containsKey(target - (num[i] + num[j]))) {
          List<int[]> ls = twoSumMap.get(target - (num[i] + num[j]));

          for (int[] pair : ls) {
            int m1 = Math.min(pair[0], i);
            int m2 = Math.min(pair[1], j);
            int m3 = Math.max(pair[0], i);
            int m4 = Math.max(pair[1], j);
            if (m1 == m3 || m1 == m4 || m2 == m3 || m2 == m4) {
              continue;
            }
            res.add(Arrays.asList(num[m1], num[Math.min(m2, m3)], num[Math.max(m2, m3)], num[m4]));
          }
        }
        twoSumMap.computeIfAbsent(num[i] + num[j], key -> new ArrayList<>()).add(new int[] {i, j});
      }
    }

    return new ArrayList<List<Integer>>(res);
  }
}
