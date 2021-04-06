package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum39 {
  /*Method: BackTrack, Time: O(N*2^N), Space:O(Target)**/
  List<List<Integer>> result = new ArrayList<>();
  List<Integer> list = new ArrayList<>();
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    backtrack(candidates, 0, target);
    return result;
  }

  private void backtrack(int[] candidates, int begin, int target) {
    if (target == 0) {
      result.add(new ArrayList<>(list));
      return;
    }
    for (int i = begin; i < candidates.length && target - candidates[i] >= 0; i++) {
      list.add(candidates[i]);
      backtrack(candidates, i, target - candidates[i]);
      list.remove(list.size() - 1);
    }
  }

}
