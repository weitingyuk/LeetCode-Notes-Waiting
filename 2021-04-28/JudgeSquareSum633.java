package Leetcode;

public class JudgeSquareSum633 {
  /* Method: Two Pointer , Time: O(sqrt(C)), Space:O(1)**/
  public boolean judgeSquareSum(int c) {
    long l=0;
    long r = (long) Math.sqrt(c);
    while(l <= r) {
      long sum = l*l + r*r;
      if(sum == c) {
        return true;
      } else if(sum > c) {
        r--;
      } else {
        l++;
      }
    }
    return false;
  }

}
