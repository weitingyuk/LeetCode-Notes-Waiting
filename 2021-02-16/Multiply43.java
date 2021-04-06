package Leetcode;

public class Multiply43 {
  /** Method1: Mock Add; Time: O(len1*len2 + len2^2); Space: O(len1+len2)) **/
  public String multiply1(String num1, String num2) {
    if(num1.equals("0") || num2.equals("0")) {   return "0";}
    String res = "0";
    int len1 = num1.length(), len2= num2.length();
    for(int i = len2 -1; i>=0; i--) {
      StringBuilder cur = new StringBuilder();
      int y = num2.charAt(i) - '0';
      int carry = 0;
      for(int j = len2 - 1; j > i; j --) {  cur.append(0); }
      for(int j = len1 -1; j>=0; j--) {
        int x = num1.charAt(j) - '0';
        int prod = x * y + carry;
        cur.append(prod % 10);
        carry = prod / 10;
      }
      if(carry != 0) {  cur.append(carry % 10); }
      res = addStrings(res, cur.reverse().toString());
    }
    return res;
  }
  private String addStrings(String num1, String num2) {
    int i = num1.length() - 1, j = num2.length() - 1, add = 0;
    StringBuffer ans = new StringBuffer();
    while (i >= 0 || j >= 0 || add != 0) {
      int x = i >= 0 ? num1.charAt(i) - '0' : 0;
      int y = j >= 0 ? num2.charAt(j) - '0' : 0;
      int result = x + y + add;
      ans.append(result % 10);
      add = result / 10;
      i--;
      j--;
    }
    ans.reverse();
    return ans.toString();
  }

  /** Method2: Use multiply; Time: O(len1*len2); Space: O(len1+len2)) **/
  public String multiply(String num1, String num2) {
    if(num1.equals("0") || num2.equals("0")) {   return "0";}
    int len1 = num1.length(), len2= num2.length();
    int[] ansArr = new int[len1 + len2];

    for(int i = len1 -1; i>=0; i--) {
      int x = num1.charAt(i) - '0';
      for(int j = len2 -1; j>=0; j--) {
        int y = num2.charAt(j) - '0';
        ansArr[i+j+1] += x * y;
      }
    }
    for(int i = len1+len2-1; i>0; i--) {
      ansArr[i-1] += ansArr[i] /10;
      ansArr[i] %= 10;
    }
    int index = ansArr[0] == 0 ? 1 : 0;
    StringBuilder res = new StringBuilder();
    while(index <  len1 +len2) {
      res.append(ansArr[index]);
      index ++;
    }
    return res.toString();
  }
}
