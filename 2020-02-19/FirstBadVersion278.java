package Leetcode;

public class FirstBadVersion278 {
  /**Method: Binary search; Time: O(log(n)); Space: O(1) **/
  public int firstBadVersion(int n) {
    int start = 0;
    int end = n;
    while(start < end) {
      int mid = start + (end - start) /2;
      if(isBadVersion(mid)) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }
    return start;
  }

  boolean isBadVersion(int version) {
    return false; //Unimplemented
  };
}
