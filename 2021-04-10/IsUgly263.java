package Leetcode;

public class IsUgly263 {
  /*Method: Math, Time: O(LogN), Space:O(1)**/
  /**
   对 n 反复除以 2,3,5，直到 n 不再包含质因数 2,3,5。
   若剩下的数等于 1, n 不包含其他质因数，是丑数；
   否则，说明 n 包含其他质因数，不是丑数。
   **/
  public boolean isUgly(int n) {
    if(n<=0){
      return false;
    }
    int[] factors = new int[]{2,3,5};
    for(int factor: factors) {
      while(n%factor ==0) {
        n /= factor;
      }

    }
    return n==1;
  }

}
