package Leetcode;

public class FirstBadVersion278 {
  /**Method: Binary search; Time: O(log(n)); Space: O(1) **/
  public int firstBadVersion(int n) {
    int s = 0, e = n;
    while(s<e) {
      int m = s+(e-s)/2;
      if(isBadVersion(m)) {
        e = m;
      } else {
        s = m+1;
      }
    }
    return s;
  }

  boolean isBadVersion(int version) {
    return false; //Unimplemented
  };
}
