package Leetcode;

public class AddStrings415 {
  /** Method: Mock Add; Time: O(max(len1, len2); Space: O(1)) **/
  public String addStrings(String num1, String num2) {
    int len1 = num1.length(), len2 = num2.length();
    int carry =0;
    int c1= len1-1, c2= len2-1;
    StringBuilder res = new StringBuilder();
    while(c1>=0 || c2>=0 || carry >0) {
      int x =c1 <0? 0: num1.charAt(c1--)-'0';
      int y = c2<0?0: num2.charAt(c2--)-'0';
      int cur = x+y+carry;
      res.append(cur%10);
      carry = cur /10;
    }
    return res.reverse().toString();
  }
}
