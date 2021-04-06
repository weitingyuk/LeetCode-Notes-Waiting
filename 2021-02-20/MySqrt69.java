package Leetcode;

public class MySqrt69 {
  /**Method1: Math method: exp && log; Time: O(1)); Space: O(1) **/
  public int mySqrt(int x) {
    if(x == 0) {
      return 0;
    }
    int ans = (int) Math.exp(0.5 * Math.log(x));
    return (long) (ans + 1) * (ans + 1) <= x ? ans + 1: ans;
  }

  /**Method2: Binary search; Time: O(log(x))); Space: O(1) **/
  public int mySqrt2(int x) {
    int start = 0;
    int end = x;
    int res = -1;
    while(start <= end) {
      int mid = start + (end-start) /2;
      if((long) mid * mid <= x) {
        res = mid;
        start = mid + 1;
      } else {
        end = mid -1;
      }
    }
    return res;
  }
}
