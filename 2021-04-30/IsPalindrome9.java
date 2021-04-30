package Leetcode;

public class sPalindrome9 {
  /**Method: Revert Number; Time: O(LogN); Space: O(1) **/
  /**
   将数字前半部分反转，然后将反转后的数字与原始数字进行比较，如果它们是相同的，那么这个数字就是回文。
   不断将原始数字除以 10，然后给反转后的数字乘上 10，所以，当原始数字小于或等于反转后的数字时，就意味着我们已经处理了一半位数的数字了。
   **/
  public boolean isPalindrome(int x) {
    if(x<0 || (x%10==0 && x!=0)) {
      return false;
    }
    int revertNumber = 0;
    while(x>revertNumber) {
      revertNumber = revertNumber * 10 + x %10;
      x/=10;
    }
    return x == revertNumber || x == revertNumber /10;
  }

}
