package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum54 {
  /*Method: Two pointers, Time: O(NLogN), Space:O(1)**/
  public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    if (num == null || num.length < 3) {
      return res;
    }
    Arrays.sort(num);
    for (int i = 0; i < num.length - 2; i++) {
      if (num[i] > 0) {
        break;
      }
      if (i > 0 && num[i] == num[i - 1]) {
        continue;
      }
      int left = i + 1;
      int right = num.length - 1;
      while (left < right) {
        int sum = num[i] + num[right] + num[left];
        if (sum == 0) {
          ArrayList<Integer> list = new ArrayList<>();
          list.add(num[i]);
          list.add(num[left]);
          list.add(num[right]);
          res.add(list);
          while (left < right && num[left] == num[left + 1]) {
            left++;
          }
          while (left < right && num[right] == num[right - 1]) {
            right--;
          }
          left++;
          right--;
        } else if (sum > 0) {
          right--;
        } else {
          left++;
        }
      }
    }
    return res;
  }
}
