package Leetcode;

public class AddBinary67 {
  /** Method:Mock; Time: O(Max(M,N));  Space:O(1);**/
  /**
   先反转这个代表二进制数字的字符串，然后低下标对应低位，高下标对应高位。
   对应位置的答案按照顺序存入答案字符串内，最终将答案串反转。
   **/
  public String addBinary(String a, String b) {
    StringBuilder res = new StringBuilder();
    int n=Math.max(a.length(), b.length()), carry =0;
    for(int i=0; i<n;i++){
      carry += i<a.length() ? (a.charAt(a.length() - 1 -i) - '0') : 0;
      carry += i<b.length() ? (b.charAt(b.length() - 1 -i) -'0') : 0;
      res.append((char) (carry % 2 + '0'));
      carry /= 2;
    }
    if(carry >0) {
      res.append('1');
    }
    res.reverse();
    return res.toString();
  }

}
