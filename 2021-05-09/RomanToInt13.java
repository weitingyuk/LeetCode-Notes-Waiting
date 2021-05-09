package Leetcode;

public class RomanToInt13 {

  /** Method: Traversal + Save Pre sum; Time: O(Len);  Space:O(1);**/
  /**
   罗马数字由 I,V,X,L,C,D,M 构成；
   当小值在大值的左边，则减小值，如 IV=5-1=4；
   当小值在大值的右边，则加小值，如 VI=5+1=6；
   由上可知，右值永远为正，因此最后一位必然为正。
   **/
  public int romanToInt(String s) {
    int sum = 0;
    int preSum = getValue(s.charAt(0));
    for(int i=1; i<s.length(); i++) {
      int num = getValue(s.charAt(i));
      if(preSum < num) {
        sum -= preSum;
      } else {
        sum += preSum;
      }
      preSum = num;
    }
    sum += preSum;
    return sum;
  }

  private int getValue(char ch) {
    switch(ch) {
      case 'I': return 1;
      case 'V': return 5;
      case 'X': return 10;
      case 'L': return 50;
      case 'C': return 100;
      case 'D': return 500;
      case 'M': return 1000;
      default: return 0;
    }
  }
}
