package Leetcode;

import java.util.Arrays;

public class FindDuplicate287 {

  /**Method1: Binary search; Time: O(Nlog(N))); Space: O(1) **/
  public int findDuplicate(int[] nums) {
    int n = nums.length;
    int start = 0;
    int end = n-1;
    int res = -1;
    while(start <= end) {
      int mid = start + (end - start) /2;
      int cnt = 0;
      for(int i = 0; i<n; i++) {
        if(mid >= nums[i]) {
          cnt ++;
        }
      }
      if(cnt <= mid) {
        start = mid + 1;
      } else {
        end = mid -1;
        res = mid;
      }
    }
    return res;
  }

  /**Method2: Two pointers; Time: O(N)); Space: O(1) **/
  public int findDuplicate2(int[] nums) {
    int slow = 0, fast= 0;
    do {
      slow = nums[slow];
      fast = nums[nums[fast]];

    } while(slow != fast);
    slow = 0;
    while (slow != fast) {
      slow = nums[slow];
      fast = nums[fast];
    }
    return slow;
  }
}
