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

  /** Method2: Binary search; Time: O(log(x))); Space: O(1) **/
  /**
   对 x 进行二分查找
   二分查找的下界为 0，上界可以粗略地设定为 x
   需要比较中间元素 m 的平方与 x 的大小关系，并通过比较的结果调整上下界的范围
   **/
  public int mySqrt2(int x) {
    int s = 0;
    int e = x;
    int res = -1;
    while(s<=e) { // 考虑只有一个值，这里应该用=
      int m = s+(e-s)/2;
      if((long) m*m <= x){ //如果是<=x的时候，应该满足要求，同时还可以更精确，注意long
        res = m;
        s = m+1;
      } else {
        e = m -1;
      }

    }
    return res;
  }
}
