package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permute46 {
  /*Method: BackTrack, Time: O(N*N!), Space:O(N)**/
  List<List<Integer>> res = new ArrayList<>();
  List<Integer> list = new ArrayList<>();
  public List<List<Integer>> permute(int[] nums) {
    boolean[] visited = new boolean[nums.length];
    backtrack(nums, 0, visited);
    return res;
  }
  private void backtrack(int[] nums, int begin, boolean[] visited) {
    if(begin == nums.length) {
      res.add(new ArrayList<>(list));
      return;
    }
    for(int i=0; i< nums.length; i++) {
      if(visited[i]) {
        continue;
      }
      visited[i] = true;
      list.add(nums[i]);
      backtrack(nums, begin + 1, visited);
      visited[i] = false;
      list.remove(list.size() - 1);
    }
  }

}
