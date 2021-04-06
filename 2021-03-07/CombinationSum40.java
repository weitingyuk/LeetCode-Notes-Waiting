package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum40 {

  /*Method: BackTrack, Time: O(N*2^N), Space:O(Target)**/
  List<List<Integer>> res = new ArrayList<>();
  List<Integer> list = new ArrayList<>();

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    if(candidates == null || candidates.length ==0 || target == 0) {
      return res;
    }
    Arrays.sort(candidates);
    backtrack(candidates, 0, target);
    return res;
  }

  private void backtrack(int[] candidates, int begin, int target) {
    if(target == 0) {
      res.add(new ArrayList<Integer>(list));
      return;
    }
    for(int i=begin; i< candidates.length && target - candidates[i] >= 0; i++) {
      if(i> begin && candidates[i] == candidates[i-1]) {
        continue;
      }
      list.add(candidates[i]);
      backtrack(candidates, i+1, target - candidates[i]);
      list.remove(list.size() - 1);
    }
  }

}
