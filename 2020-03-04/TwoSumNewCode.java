package Leetcode;

import java.util.HashMap;

public class TwoSumNewCode {

  /*Method : Map store <target-num[i], i>, Time: O(N), Space:O(N)**/
  public int[] twoSum (int[] numbers, int target) {
    int[] res = new int[2];
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i=0; i< numbers.length; i++) {
      if(map.containsKey(numbers[i])) {
        res[0] = map.get(numbers[i]) + 1;
        res[1] = i + 1;
      } else {
        map.put(target - numbers[i], i);
      }
    }
    return res;
  }
}
