package Leetcode;

public class AddStrings415 {
  /** Method: Mock Add; Time: O(max(len1, len2); Space: O(1)) **/
  public String addStrings(String num1, String num2) {
    int i = num1.length() -1;
    int j = num2.length() -1;
    int carry = 0;
    StringBuilder res = new StringBuilder();
    while(i >= 0 || j >= 0 || carry != 0) {
      int x = i >= 0? num1.charAt(i) - '0' : 0;
      int y = j >= 0? num2.charAt(j) - '0' : 0;
      int result =  x + y + carry;
      res.append(result % 10);
      carry = result / 10;
      i --;
      j --;
    }
    return res.reverse().toString();
  }
}
